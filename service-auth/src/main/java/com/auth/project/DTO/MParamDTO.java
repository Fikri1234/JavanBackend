/**
 * 
 */
package com.auth.project.DTO;


import com.auth.project.Entity.MParamEntity;

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
public class MParamDTO {
	
	Integer id;
	String paramName;
	String paramValue;
	String paramDescription;
	
	public MParamDTO(MParamEntity entity) {
		super();
		this.id = entity.getId();
		this.paramName = entity.getParamName();
		this.paramValue = entity.getParamValue();
		this.paramDescription = entity.getParamDescription();
	}

}
