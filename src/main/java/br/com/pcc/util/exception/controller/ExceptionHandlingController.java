package br.com.pcc.util.exception.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.util.exception.entity.GenericExceptionEntity;

@ControllerAdvice
public class ExceptionHandlingController {
	@ExceptionHandler(GenericExceptionEntity.class)
	@ResponseBody
	public GenericExceptionEntity handleGenericException(GenericExceptionEntity e, HttpServletResponse response) {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		return e;
	 }
}