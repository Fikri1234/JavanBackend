/**
 * 
 */
package com.pajak.project.DTO;

import java.util.Date;

import com.pajak.project.Entity.PajakEntity;
import com.pajak.project.Enum.RoleEnum;
import com.pajak.project.Enum.StatusEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author user on 2023-03-17 05:36:36.207
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PajakDTO {
	
	Long id;
	
	String nomorResi;
	
	Date tanggal;
	
	StatusEnum status = StatusEnum.PENDING;

	String createdBy;
	
	Date createdDate;
	RoleEnum role;
	
	String updatedBy;
	Date updatedDate;
	RoleEnum updateRole = RoleEnum.USER;
	
	/**
	 * @param id
	 * @param nomorResi
	 * @param tanggal
	 * @param status
	 */
	public PajakDTO(PajakEntity entity) {
		super();
		this.id = entity.getId();
		this.nomorResi = entity.getNomorResi();
		this.tanggal = entity.getTanggal();
		this.status = entity.getStatus();
		this.createdBy = entity.getCreatedBy();
		this.createdDate = entity.getCreatedDate();
		this.role = entity.getRole();
		this.updatedBy = entity.getUpdatedBy();
		this.updatedDate = entity.getCreatedDate();
		this.updateRole = entity.getUpdateRole();
	}
	
	

}
