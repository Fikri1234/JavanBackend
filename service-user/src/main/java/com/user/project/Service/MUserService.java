/**
 * 
 */
package com.user.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.user.project.Entity.MUserEntity;
import com.user.project.Enum.RoleEnum;


/**
 * @author Fikri
 *
 */
public interface MUserService {
	
	List<MUserEntity> findAll();
	Page<MUserEntity> findAll(Pageable pageable);
	Optional<MUserEntity> findById(Long id);
	void save(MUserEntity entity);
	void update(MUserEntity entity);
	void delete(MUserEntity entity);
	void deleteById(Long id);
	
	Optional<MUserEntity> findByEmail(String email);
	List<MUserEntity> findByEmailOrderByIdDesc(String email);
	
	RoleEnum getRole();

}
