package com.alayon.app.injection;


public class PrototypeInjectionOnlyMessageService {
	
	private int counter = 1;
	
	public String getMessage() {
		return counter++ + ": PrototypeInjectionOnlyMessageService!!!";
	}
}
