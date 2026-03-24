package com.practice.task_management_api_service.exception;

public class UserNameNotFoundException extends RuntimeException{

	public UserNameNotFoundException(String message) {
		super(message);
	}
}
