package com.base.normalindia.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.base.normalindia.entity.UserOtp;


public interface UserOtpRepository  extends JpaRepository<UserOtp,Long>{
	
	UserOtp findByToken(String token);

}
