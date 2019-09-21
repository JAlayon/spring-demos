package com.alayon.app;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alayon.app.injection.InjectionMain;

@SpringBootApplication
public class SpringDemosApplication implements CommandLineRunner {

	@Autowired
	private InjectionMain injectionMain;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDemosApplication.class, args);
	}

	// Nos permite testear aspectos puntuales
	@Override
	public void run(String... args) throws Exception {
		if(args.length > 0) {
			switch (args[0]) {  
				case "injection":							//mvn clean spring-boot:run -Dspringboot.run.arguments="injection"
					this.injectionMain.debugAndClose();
					break;
				default:
					Logger.getLogger(this.getClass().getSimpleName()).warning(">>>>>> Invalid Option");
					break;
				}
		}else {
			Logger.getLogger(this.getClass().getSimpleName()).info(">>>>>>> You didn't specify an option");
		}
	}
	

}
