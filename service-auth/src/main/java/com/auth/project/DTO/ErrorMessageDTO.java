/**
 * 
 */
package com.auth.project.DTO;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Fikri
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessageDTO {
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	Instant timestamp;
	String message;
	String details;
	String url;

}
