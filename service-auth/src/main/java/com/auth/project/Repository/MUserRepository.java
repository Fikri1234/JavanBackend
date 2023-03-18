/**
 * 
 */
package com.auth.project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.project.Entity.MUserEntity;


/**
 * @author Fikri
 *
 */
@Repository
public interface MUserRepository extends JpaRepository<MUserEntity, Long> {
	
	Optional<MUserEntity> findByEmail(String email);
	
	List<MUserEntity> findByEmailOrderByIdDesc(String email);

}
