package com.alayon.app.aspect.target;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.alayon.app.aspect.MyClassAnnotation;
import com.alayon.app.aspect.MyMethodAnnotation;

/**
 * This class represents whose will apply the advices
 * @author alayon
 *
 */
@Service
@MyClassAnnotation
public class MockService {

	
	public void method() {
		Logger.getLogger("SPRING-DEMOS").info("------------> MockService:method()");
	}
	
	public void methodWithArg(String arg) {
		Logger.getLogger("SPRING-DEMOS").info("------------> MockService:methodWithArg()");
	}
	
	
	public int methodReturnInt() {
		Logger.getLogger("SPRING-DEMOS").info("------------> MockService:methodReturnInt()");
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt(100);
	}
	
	public void methodWithException() throws Exception{
		Logger.getLogger("SPRING-DEMOS").info("------------> MockService:methodWithException()");
		throw new Exception("exception!!!!!!");
	}
	
	
	@MyMethodAnnotation
	public void methodAnnotation() {
		Logger.getLogger("SPRING-DEMOS").info("------------> MockService:methodAnnotation()");
	}
	
	
}
