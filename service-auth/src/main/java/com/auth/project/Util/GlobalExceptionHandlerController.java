package com.auth.project.Util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.auth.project.Constant.StatusConstant;


@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest webRequest) {
        
        Map<String, Object> map = new HashMap<>();
        map.put(StatusConstant.CODE, ex.getHttpStatus().value());
        map.put(StatusConstant.MSG, ex.getMessage());
		
		return new ResponseEntity<>(map, ex.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex, HttpServletResponse res) {
		
        Map<String, Object> map = new HashMap<>();
        map.put(StatusConstant.CODE, HttpStatus.BAD_REQUEST.value());
        map.put(StatusConstant.MSG, "Something went wrong");
        
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

}
