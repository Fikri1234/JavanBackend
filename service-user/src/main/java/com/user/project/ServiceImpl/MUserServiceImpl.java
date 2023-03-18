/**
 * 
 */
package com.user.project.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.project.Entity.MUserEntity;
import com.user.project.Enum.RoleEnum;
import com.user.project.Repository.MUserRepository;
import com.user.project.Service.MUserService;
import com.user.project.Util.GeneralUtil;


/**
 * @author Fikri
 *
 */

@Service
public class MUserServiceImpl implements MUserService {
	
	private MUserRepository repository;
	private GeneralUtil generalUtil;

	/**
	 * @param repository
	 * @param generalUtil
	 */
	public MUserServiceImpl(MUserRepository repository, GeneralUtil generalUtil) {
		super();
		this.repository = repository;
		this.generalUtil = generalUtil;
	}

	@Override
	public Optional<MUserEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<MUserEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Page<MUserEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public void save(MUserEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public void update(MUserEntity entity) {
		repository.save(entity);
	}

	@Override
	public void delete(MUserEntity entity) {
		// TODO Auto-generated method stub
		repository.deleteById(entity.getId());
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<MUserEntity> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public List<MUserEntity> findByEmailOrderByIdDesc(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmailOrderByIdDesc(email);
	}
	
	@Override
	public RoleEnum getRole() {

		String email = generalUtil.getUserIdFromToken();
		Optional<MUserEntity> opt = findByEmail(email);
		if (opt.isPresent()) {
			return opt.get().getRole();
		}
		return null;
	}

}