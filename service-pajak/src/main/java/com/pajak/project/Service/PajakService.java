/**
 * 
 */
package com.pajak.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pajak.project.DTO.MUserDTO;
import com.pajak.project.Entity.PajakEntity;
import com.pajak.project.Enum.RoleEnum;


/**
 * @author Fikri
 *
 */
public interface PajakService {
	
	List<PajakEntity> findAll();
	Page<PajakEntity> findAll(Pageable pageable);
	Optional<PajakEntity> findById(Long id);
	void save(PajakEntity entity);
	void update(PajakEntity entity);
	void delete(PajakEntity entity);
	void deleteById(Long id);
	
	List<PajakEntity> findByStatus(String status);
	
	List<PajakEntity> findByRole(RoleEnum roleEnum);
	
	MUserDTO getUser();

}
