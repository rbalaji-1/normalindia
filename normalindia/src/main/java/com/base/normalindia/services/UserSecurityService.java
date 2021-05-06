package com.base.normalindia.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.normalindia.entity.UserOtp;
import com.base.normalindia.repository.UserOtpRepository;


@Service
	@Transactional
	public class UserSecurityService implements ISecurityUserService {

	    @Autowired
	    private UserOtpRepository otprepo ;

	    @Override
	    public String validateOtpToken(String token) {
	        final UserOtp usertoken = otprepo.findByToken(token);

	        return !isTokenFound(usertoken) ? "invalidToken"
	                : isTokenExpired(usertoken) ? "expired"
	                : null;
	    }

	    private boolean isTokenFound(UserOtp passToken) {
	        return passToken != null;
	    }

	    private boolean isTokenExpired(UserOtp passToken) {
	        final Calendar cal = Calendar.getInstance();
	        return passToken.getExpiryDate().before(cal.getTime());
	    }
	}


