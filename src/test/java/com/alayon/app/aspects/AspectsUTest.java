package com.alayon.app.aspects;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alayon.app.aspect.target.MockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectsUTest {
	
	@Autowired
	private MockService service;

	@Test
	public void methodTest() {
		Logger.getLogger("com.alayon.app").info("========================= INIT TEST =========================");
		service.method();
		Logger.getLogger("com.alayon.app").info("========================= TEST OVER =========================");
	}
	
	@Test
	public void methodWithArgTest() {
		Logger.getLogger("com.alayon.app").info("========================= INIT TEST =========================");
		service.methodWithArg("TEST");
		Logger.getLogger("com.alayon.app").info("========================= TEST OVER =========================");
	}
	
	@Test
	public void methodReturnIntTest() {
		Logger.getLogger("com.alayon.app").info("========================= INIT TEST =========================");
		service.methodReturnInt();
		Logger.getLogger("com.alayon.app").info("========================= TEST OVER =========================");
	}
}
