package com.base.normalindia.servlet;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.normalindia.entity.User;
import com.base.normalindia.repository.UserRepository;
import com.base.normalindia.services.ISecurityUserService;
import com.base.normalindia.services.UserService;
import com.base.normalindia.util.GenericResponse;
import com.base.normalindia.util.MessageResponse;
import com.base.normalindia.util.OtpToken;




@RestController("/api")
public class UserController {
	
	@Autowired
	UserRepository usr;
	
	@Autowired
	UserService usc;
	

	@Autowired
    private MessageSource messages;
	
@Autowired 
	
	private ISecurityUserService securityUserService;
	
	
	@PostMapping("/user/sigin")
	public ResponseEntity<?> signin(final HttpServletRequest request,@RequestParam("phonenumber") String phonenumber){
	
		GenericResponse gr=null;
		try {
		User usre=usr.findByphonenumber(phonenumber).get();
		if (usre!=null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Already Registered"));
		}
		String token = UUID.randomUUID().toString();
	    usc.createOtpForUser(usre, token);
	    
	    
	   gr= new GenericResponse(
	  	      messages.getMessage("message.resetPasswordEmail", null, 
	  	      request.getLocale()));
		}
		catch(Exception e) {
			
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(e.getStackTrace().toString()));
		
		}
		
	
		return new ResponseEntity<>(gr,HttpStatus.OK);
		
		
		
	}
	
	  @PostMapping("/user/activateuser")
	    public GenericResponse activateuser(final Locale locale, @Valid @RequestBody OtpToken otptoken) {
try {
	       final String result = securityUserService.validateOtpToken(otptoken.getToken());
 if(result != null) {
	            return new GenericResponse(messages.getMessage("auth.message." + result, null, locale));
	        }

	        User user = usc.getUserByOtpToken(otptoken.getToken());
	        if(user!=null) {
	            
	            
	            usc.activateuser(user);
	            return new GenericResponse(messages.getMessage("message.Otpverificationsuccsess", null, locale));
	        } else {
	            return new GenericResponse(messages.getMessage("auth.message.invalid", null, locale));
	        }
}
catch(Exception e) {
	
	return new GenericResponse(messages.getMessage(e.getMessage(), null, locale));
}

	    }
	  
	  
	  

}
