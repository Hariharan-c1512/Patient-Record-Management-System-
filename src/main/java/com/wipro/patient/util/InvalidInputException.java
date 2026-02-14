package com.wipro.patient.util;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 1L;
	public InvalidInputException()
	{
		super();
	}
	public String toString()
	{
	    return "Invalid Input";
	}
}
