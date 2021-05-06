package com.base.normalindia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.normalindia.entity.User;
import com.base.normalindia.repository.UserOtpRepository;
import com.base.normalindia.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	UserOtpRepository otprepo;
	
	@Autowired
	UserRepository usr;

	public void createOtpForUser(User usre, String token) {
		// TODO Auto-generated method stub
		
	}
	
	
	public User getUserByOtpToken(String token) {
		// TODO Auto-generated method stub
		
		
		return otprepo.findByToken(token).getUser();
	}

	public void activateuser(User user) {
		// TODO Auto-generated method stub
		
		user.setActive(true);
		usr.save(user);
		
	}
	

}
