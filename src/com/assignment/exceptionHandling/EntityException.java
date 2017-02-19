package com.assignment.exceptionHandling;

public class EntityException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 15938573967359L;

	public EntityException(){
		super();
	}
	
	public EntityException(String message){
		super(message);
	}
}
