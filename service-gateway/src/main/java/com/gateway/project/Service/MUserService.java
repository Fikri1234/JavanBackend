/**
 * 
 */
package com.gateway.project.Service;

import java.util.List;
import java.util.Optional;

import com.gateway.project.Entity.MUserEntity;


/**
 * @author Fikri
 *
 */
public interface MUserService {
	
	Optional<MUserEntity> findById(Long id);
	void save(MUserEntity entity);
	void update(MUserEntity entity);
	void delete(MUserEntity entity);
	void deleteById(Long id);
	
	Optional<MUserEntity> findByEmail(String email);
	List<MUserEntity> findByEmailOrderByIdDesc(String email);

}
