/**
 * 
 */
package com.pajak.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pajak.project.Entity.PajakEntity;
import com.pajak.project.Enum.RoleEnum;


/**
 * @author Fikri
 *
 */
@Repository
public interface PajakRepository extends JpaRepository<PajakEntity, Long> {
	
	List<PajakEntity> findByStatus(String status);
	
	List<PajakEntity> findByRole(RoleEnum roleEnum);

}
