/**
 * 
 */
package com.user.project.Util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.project.Constant.ParamConstant;
import com.user.project.Entity.MParamEntity;
import com.user.project.Service.MParamService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * @author Fikri
 *
 */

@Component
public class GeneralUtil {
	
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private MParamService mParamService;

	public String getUserIdFromToken() {
		String bearerToken = httpServletRequest.getHeader("Authorization");
		
		try {
			String token = bearerToken.replace("Bearer ", "");
			String jwtKey = "";
			
			Optional<MParamEntity> opt = mParamService.findByParamName(ParamConstant.JWT_KEY);
			if (opt.isPresent()) {
				jwtKey = opt.get().getParamValue();
			}
			
			Jws<Claims> claims = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token);
			return claims.getBody().getSubject();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Unknown";
		}
	}

}
