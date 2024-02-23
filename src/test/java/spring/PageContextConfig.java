package spring;

import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import pageObjects.LoginPage;
import pageObjects.LoginSecPage;
import tests.BaseTest;

@Configuration
@ComponentScan(basePackages = {"pageObjects"})
public class PageContextConfig {

    @Bean({"dexcomDriver"})
    public BaseTest baseTest() {
        return new BaseTest();
    }

   /* @Bean()
    @Lazy
    public AppiumDriver<?> appiumDriver() {
        return baseTest().startAppiumDriver();
    }*/

    @Autowired
    @Qualifier("appiumDriver")
    @Lazy
    private transient AppiumDriver<?> appiumDriver;

    @Bean
    @DependsOn({"appiumDriver"})
    @Lazy
    public LoginPage loginPage() {
        return new LoginPage(appiumDriver);
    }

    @Bean
    @DependsOn({"appiumDriver"})
    @Lazy
    public LoginSecPage loginSecPage() {
        return new LoginSecPage(appiumDriver);
    }

}
