package tests;

import annotations.LoginType;
import io.appium.java_client.android.AndroidDriver;
import logging.Logs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BaseTest {
    public AppiumDriver<MobileElement> driver = null;
    AppiumDriverLocalService service;
    Logs loggerObj = new Logs();

    public BaseTest() {

    }

   @BeforeClass
    void setUp() {
       startAppiumServer();
       startAppiumDriver();
    }

    @BeforeMethod
    public void beforeTest(Method method){
        getLoginDetails(method.getAnnotation(LoginType.class).value());
    }


    void getLoginDetails(LoginType.LoginTypeNames loginTypeNamesParameter) {
        if (loginTypeNamesParameter == null || loginTypeNamesParameter.equals(LoginType.LoginTypeNames.NO_LOGIN)) {
            System.out.println("No Login is Required.");
        } else {
            switch (loginTypeNamesParameter) {
                case LOGIN_FIRSTPAGE:
                    System.out.println("Only First Page Login is Required.");
                    break;
                case LOGIN_SECPAGE:
                    System.out.println("Only SECOND Page Login is Required.");
                    break;
                default:
                    throw new IllegalArgumentException( "This value is not supported");
            }
        }
    }

    void startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(8099)
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/bin/appium"));
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        loggerObj.logger.debug("Start Appium Server!");
        System.out.println("Start Appium Server! __________");
        service.start();
    }

    public AppiumDriver<MobileElement> startAppiumDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Users/pa0716/Desktop/d1.apk");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Samsung S21+ 5G");
        capabilities.setCapability("appPackage","com.dexcom.dexcomone");
        capabilities.setCapability("appActivity","com.dexcom.phoenix.ui.SplashActivity");
       // driver = new AppiumDriver<>(service.getUrl(),capabilities);
        driver = new AndroidDriver<>(service.getUrl(),capabilities);
        return driver;
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
       // service.stop();
    }

}
