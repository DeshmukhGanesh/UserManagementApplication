package com.BikkadIT.UserManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.UserManagementApplication.binding.LoginForm;
import com.BikkadIT.UserManagementApplication.service.UserServiceI;
import com.BikkadIT.UserManagementApplication.service.UserServiceImpl;

@RestController
public class LoginCheckController {

	@Autowired
	private UserServiceI userServiceI;
	
	public ResponseEntity<String> loginCheck(@RequestBody LoginForm loginForm){
		
		String loginCheck = userServiceI.loginCheck(loginForm);
		
		return new ResponseEntity<String>(loginCheck,HttpStatus.OK);
		
	}
	
}
