package tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"tests"})
public class AppConfig {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}


