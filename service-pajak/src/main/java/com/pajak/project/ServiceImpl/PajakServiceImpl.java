/**
 * 
 */
package com.pajak.project.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pajak.project.Consumer.UserConsumer;
import com.pajak.project.DTO.MUserDTO;
import com.pajak.project.Entity.PajakEntity;
import com.pajak.project.Enum.RoleEnum;
import com.pajak.project.Repository.PajakRepository;
import com.pajak.project.Service.PajakService;
import com.pajak.project.Util.GeneralUtil;


/**
 * @author Fikri
 *
 */

@Service
public class PajakServiceImpl implements PajakService {
	
	@Autowired
	private PajakRepository repository;
	
	@Autowired
	private GeneralUtil generalUtil;
	
	@Autowired
	private UserConsumer userConsumer;

	@Override
	public Optional<PajakEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<PajakEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Page<PajakEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public void save(PajakEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public void update(PajakEntity entity) {
		repository.save(entity);
	}

	@Override
	public void delete(PajakEntity entity) {
		// TODO Auto-generated method stub
		repository.deleteById(entity.getId());
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<PajakEntity> findByStatus(String status) {
		// TODO Auto-generated method stub
		return repository.findByStatus(status);
	}

	@Override
	public List<PajakEntity> findByRole(RoleEnum roleEnum) {
		// TODO Auto-generated method stub
		return repository.findByRole(roleEnum);
	}
	
	@Override
	public MUserDTO getUser() {
		String email = generalUtil.getUserIdFromToken();
		return userConsumer.findByEmail(email);
	}

}
