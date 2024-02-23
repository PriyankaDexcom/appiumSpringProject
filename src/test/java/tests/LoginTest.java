package tests;

import annotations.LoginType;
import logging.Logs;
import org.testng.annotations.Test;
import steps.LoginStep;

import java.io.IOException;

public class LoginTest extends BaseTest {
    Logs loggerObj = new Logs();
    LoginStep loginStep = new LoginStep();

    @LoginType(value = LoginType.LoginTypeNames.NO_LOGIN)
    @Test
    public void launchApp() {
     //   driver.launchApp();
        loggerObj.logger.info("Launched the APP");
    }

    @LoginType(value = LoginType.LoginTypeNames.LOGIN_FIRSTPAGE)
    @Test
    public void login () throws IOException {
        loginStep.loginFirstScreen(driver);
        loginStep.loginSecScreen(driver);
    }
}
