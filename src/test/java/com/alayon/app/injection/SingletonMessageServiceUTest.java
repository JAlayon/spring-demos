package com.alayon.app.injection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author alayon
 * This is a simple test without using spring
 *
 */
public class SingletonMessageServiceUTest {

	private SingletonMessageService sms;
	
	@Before
	public void initTests() {
		sms = new SingletonMessageService();
	}
	
	@Test
	public void testMessage() {
		for(int i = 1; i <= 9; i++) {
			assertThat(String.valueOf(i), is(equalTo(sms.getMessage().substring(0,1))));
		}
	}
	
}
