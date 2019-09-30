package com.alayon.app.injection;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author alayon
 * This is a test using spring and mocks
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectionMainUTestSpring {


	@Autowired
	private InjectionMain injectionMain;
	
	@MockBean
	private SingletonMessageService sms;
	
	@Test
	public void testGetMessage() {
		//given(this.sms.getMessage()).willReturn("ok");
		when(this.sms.getMessage()).thenReturn("OK");
		assertEquals("OK", injectionMain.getMessage());
	}
}
