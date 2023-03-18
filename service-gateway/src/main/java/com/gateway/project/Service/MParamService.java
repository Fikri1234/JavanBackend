/**
 * 
 */
package com.gateway.project.Service;

import java.util.Optional;

import com.gateway.project.Entity.MParamEntity;


/**
 * @author Fikri
 *
 */
public interface MParamService {
	
	Optional<MParamEntity> findById(Integer id);
	void save(MParamEntity entity);
	void update(MParamEntity entity);
	void delete(MParamEntity entity);
	void deleteById(Integer id);
	
	Optional<MParamEntity> findByParamName(String paramName);

}
