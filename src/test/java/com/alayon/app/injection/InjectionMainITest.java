package com.alayon.app.injection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author alayon This is an integration test example from InjectionMain class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectionMainITest {

	@Autowired
	private InjectionMain injectionMain;

	@Test
	public void testGetMessage() {
		for(int i=1; i < 9; i++) {
			assertThat(String.valueOf(i), is(equalTo(injectionMain.getMessage().substring(0,1))));
		}
		
	}
}
