/**
 * 
 */
package com.auth.project.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.auth.project.Entity.MUserEntity;
import com.auth.project.Repository.MUserRepository;
import com.auth.project.Service.MUserService;
import com.auth.project.Util.GeneralUtil;


/**
 * @author Fikri
 *
 */

@Service
public class MUserServiceImpl implements MUserService {
	
	private MUserRepository repository;
	private GeneralUtil generalUtil;

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
		Optional<MUserEntity> opt = repository.findById(entity.getId());
		if (opt.isPresent()) {
			String userId = generalUtil.getUserIdFromToken();
			opt.get().setEmail(userId);
			update(opt.get());
		}
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

}
