package com.lattice.innovation.exception;

public class ContentNotMatchException extends RuntimeException {
	private String message;
	private String content;
	
	public  ContentNotMatchException(String message,String content) {
		super(String.format("%s , invalid %s",message,content));
		this.message = message;
		this.content=content;
		
}
}