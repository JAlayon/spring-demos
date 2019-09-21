package com.alayon.app.injection;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InjectionMain{

	@Autowired
	private ConfigurableApplicationContext applicationContext;
	
	/**
	 * Dependencias singleton
	 */
	@Autowired
	private SingletonMessageService singletonMessageService;

	@Autowired
	private SingletonMessageService singletonMessageService2;

	
	/**
	 * Dependencias prototype
	 */
	
	@Autowired
//	@Qualifier("poms")
	private PrototypeInjectionOnlyMessageService prototypeInjectionOnlyMessageService;

	@Autowired
	//@Qualifier("poms")
	private PrototypeInjectionOnlyMessageService prototypeInjectionOnlyMessageService2;


	
	public void debugAndClose() {
		Logger.getLogger(this.getClass().getSimpleName()).info(">>>>>>> message: " + this.singletonMessageService.getMessage());
		Logger.getLogger(this.getClass().getSimpleName()).info(">>>>>>> message: " + this.singletonMessageService2.getMessage());
		
		Logger.getLogger(this.getClass().getSimpleName()).info(">>>>>>> message: " + this.prototypeInjectionOnlyMessageService.getMessage());
	    Logger.getLogger(this.getClass().getSimpleName()).info(">>>>>>> message: " + this.prototypeInjectionOnlyMessageService2.getMessage());
		
		applicationContext.close();
	}
	
}
