/**
 * 
 */
package com.pajak.project.Consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pajak.project.DTO.MUserDTO;

/**
 * @author Fikri
 *
 */

@FeignClient(name="service-user")
public interface UserConsumer {
	
	@GetMapping("email/{email}")
	public MUserDTO findByEmail(@PathVariable String email);

}
