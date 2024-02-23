package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(classes = {AppConfig.class})
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testSayHello() {
        System.out.println("**************************");
        String greeting = helloService.sayHello();
        System.out.println(greeting);
        // Assert.assertEquals(greeting, "Hello, world!"); // Add assertion as needed
    }
}

