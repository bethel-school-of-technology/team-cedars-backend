package com.cedarsbackend.events;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//if a resource does not exist in the database, throw this exception..
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExepction extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExepction(String message) {
		super(message);
	}
	

}