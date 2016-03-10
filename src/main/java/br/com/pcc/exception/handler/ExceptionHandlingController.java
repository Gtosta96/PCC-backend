package br.com.pcc.exception.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.exception.model.GenericException;

@ControllerAdvice
public class ExceptionHandlingController {
	@ExceptionHandler(GenericException.class)
	@ResponseBody
	public GenericException handleGenericException(GenericException e, HttpServletResponse response) {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		return e;
	 }
}
