package junit.test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		String string = (String)ac.getBean("string");
		System.out.println(string);
	}
}
