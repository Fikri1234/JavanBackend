/**
 * 
 */
package com.auth.project.Util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.auth.project.Constant.ParamConstant;
import com.auth.project.Entity.MParamEntity;
import com.auth.project.Service.MParamService;

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
	private MParamService mParamService;
	
	public GeneralUtil(HttpServletRequest httpServletRequest, MParamService mParamService) {
		super();
		this.httpServletRequest = httpServletRequest;
		this.mParamService = mParamService;
	}

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
