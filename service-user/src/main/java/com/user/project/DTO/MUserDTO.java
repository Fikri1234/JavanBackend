/**
 * 
 */
package com.user.project.DTO;

import com.user.project.Entity.MUserEntity;
import com.user.project.Enum.RoleEnum;

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
	
	Long id;
	String email;
	String password;
	private RoleEnum role;

	public MUserDTO(MUserEntity entity) {
		super();
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.role = entity.getRole();
	}

}