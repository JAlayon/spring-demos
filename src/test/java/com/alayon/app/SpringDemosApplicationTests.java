package com.alayon.app;

import com.alayon.app.injection.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * 
 * @author alayon
 * This is a Suite of classes in order to test all other tests.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	//InjectionMainITest.class,
	InjectionMainUTestSpring.class,
	SingletonMessageServiceUTest.class,
	SingletonMessageServiceUTestSpring.class
})
public class SpringDemosApplicationTests {

}
