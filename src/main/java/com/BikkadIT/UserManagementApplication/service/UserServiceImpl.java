package com.BikkadIT.UserManagementApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.UserManagementApplication.binding.LoginForm;
import com.BikkadIT.UserManagementApplication.entities.UserAccountEntity;
import com.BikkadIT.UserManagementApplication.repositories.UserAccountRepository;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public String loginCheck(LoginForm loginform) {
		UserAccountEntity userAccountEntity = userAccountRepository.findByEmailAndPassword(loginform.getEmail(), loginform.getPsaaword());
		if(userAccountEntity!=null) {
			 String accStatus = userAccountEntity.getAccStatus();
			if(accStatus.equals("LOCKED")) {
				
				return "Your Account is Locked";
			}
			else
			{
				return "loging Successfull";
			}
			
		}else {
			return "User Credientials Are Invalid";
		}
	}

}
