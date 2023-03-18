/**
 * 
 */
package com.user.project.DTO;

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
public class MUserQuery {
	
	String email;
	private RoleEnum role;

}
