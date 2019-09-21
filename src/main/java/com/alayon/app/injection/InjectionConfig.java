package com.alayon.app.injection;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * Por defecto se busca en la raiz de
 * src/main/resources/application.properties @PropertySource("classpath:myname.properties") @PrpertySource("file:///C:/projects/myname.properties")
 * <= Ruta indicada @PropertySource("http://myserver/application.properties") <=
 * URL
 * 
 * @ConfigurationProperties(prefix = "spring") <= para no escribir el prefijo
 */
@Configuration
public class InjectionConfig {

	@Bean
	@Scope("prototype")
//	@Qualifier("poms")
	public PrototypeInjectionOnlyMessageService getPrototypeInjectionOnlyMessageService() {
		Logger.getLogger("SPRING-DEMOS: " + this.getClass().getSimpleName())
				.info(">>>>>>>>> creating bean PrototypeInjetionOnlyMessageService");

		return new PrototypeInjectionOnlyMessageService();
	}
}
