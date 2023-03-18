/**
 * 
 */
package com.auth.project.ServiceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.auth.project.Entity.MParamEntity;
import com.auth.project.Repository.MParamRepository;
import com.auth.project.Service.MParamService;


/**
 * @author Fikri
 *
 */

@Service
public class MParamServiceImpl implements MParamService {
	
	private MParamRepository repository;

	public MParamServiceImpl(MParamRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public Optional<MParamEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void save(MParamEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public void update(MParamEntity entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
	}

	@Override
	public void delete(MParamEntity entity) {
		// TODO Auto-generated method stub
		Optional<MParamEntity> opt = repository.findById(entity.getId());
		if (opt.isPresent()) {
			save(opt.get());
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<MParamEntity> findByParamName(String paramName) {
		// TODO Auto-generated method stub
		return repository.findByParamName(paramName);
	}

}
