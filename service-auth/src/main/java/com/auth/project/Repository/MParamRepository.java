/**
 * 
 */
package com.auth.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.project.Entity.MParamEntity;


/**
 * @author Fikri
 *
 */

@Repository
public interface MParamRepository extends JpaRepository<MParamEntity, Integer> {

	Optional<MParamEntity> findByParamName(String paramName);

}