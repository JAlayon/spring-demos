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
 * @author alayon
 * This is a simple test with spring environment
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@TestPropertySource(locations = "classpath:test.properties")
public class SingletonMessageServiceUTestSpring {
	
	@Autowired
	private SingletonMessageService sms;
	
	
	@Test
	public void testMessage() {
		for(int i = 1; i < 9; i++) {
			assertThat(String.valueOf(i), is(equalTo(sms.getMessage().substring(0,1))));
		}
	}

}
