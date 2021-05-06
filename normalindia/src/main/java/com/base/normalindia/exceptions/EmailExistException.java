package com.base.normalindia.exceptions;

public class EmailExistException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public EmailExistException(String msg) {
	    super(msg);
	  }
	  
}
