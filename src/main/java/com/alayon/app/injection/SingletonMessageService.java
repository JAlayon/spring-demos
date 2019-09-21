package com.alayon.app.injection;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


// @Service("singletonMessageService") o @Service(value="singletonMessageService") por defecto
// @Scope("prototype") por defecto singleton

@Service
public class SingletonMessageService {
	
	@Value("${demos.name}")
	private String name;
	
	
	private int counter = 1;
	
	
	@PostConstruct
	public void constructor() {
		Logger.getLogger("SPRING-DEMOS: " + this.getClass().getSimpleName())
				.info(">>>>>>>>> SingletonMessageService::constructor()");
	}
	
	@PreDestroy
	public void destroy() {
		Logger.getLogger("SPRING-DEMOS: " + this.getClass().getSimpleName())
				.info(">>>>>>>>> SingletonMessageService::destroy()");
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return counter++ + ": SingletonMessageService!!! miw.name = " + name;
	}
}
