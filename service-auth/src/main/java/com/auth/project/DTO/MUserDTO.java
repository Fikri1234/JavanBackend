/**
 * 
 */
package com.auth.project.DTO;

import com.auth.project.Entity.MUserEntity;
import com.auth.project.Enum.RoleEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author Fikri
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MUserDTO {
	
	long id;
	String email;
	String password;
	RoleEnum role;

	public MUserDTO(MUserEntity entity) {
		super();
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.role = entity.getRole();
	}

}
