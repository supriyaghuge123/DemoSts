package com.cjc.main.exception_responce;

import java.util.Date;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.entity.BaseResponse;
import com.cjc.main.entity.User;
import com.cjc.main.exception.UserNotFoundException;
@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public BaseResponse<User> handleUserNotFoundException()
	{
		return new BaseResponse<User>(404, "User Not Found", new Date(), null);
		
	}
	

}
