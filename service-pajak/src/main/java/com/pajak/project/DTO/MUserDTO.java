/**
 * 
 */
package com.pajak.project.DTO;

import com.pajak.project.Enum.RoleEnum;

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

}
