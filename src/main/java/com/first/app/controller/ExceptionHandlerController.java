package com.first.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.first.app.bean.ErrorResponseBean;
import com.first.app.exception.TechnicalException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<ErrorResponseBean> getErrorMessage(TechnicalException technicalException,WebRequest request)
	{
		ErrorResponseBean responseBean=new ErrorResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value(),technicalException.getMessage());
		
		return new ResponseEntity<ErrorResponseBean> (responseBean,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
