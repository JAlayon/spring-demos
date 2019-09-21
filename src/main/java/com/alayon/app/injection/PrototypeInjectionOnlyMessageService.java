package com.alayon.app.injection;

import org.springframework.stereotype.Service;

public class PrototypeInjectionOnlyMessageService {
	
	private int counter = 1;
	
	public String getMessage() {
		return counter++ + ": PrototypeInjectionOnlyMessageService!!!";
	}
}
