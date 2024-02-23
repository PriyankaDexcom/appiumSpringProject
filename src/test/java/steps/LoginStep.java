package steps;

import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import pageObjects.LoginPage;
import pageObjects.LoginSecPage;
import spring.PageContextConfig;
import utils.DevProperty;

import java.io.IOException;

@ContextConfiguration(classes = {PageContextConfig.class})
@Service
public class LoginStep {

    @Autowired
    @Lazy
    private LoginPage loginPage;

    @Autowired
    @Lazy
    private LoginSecPage loginSecPage;

   // LoginPage loginPage = null;
   // LoginSecPage loginSecPage = null;
    DevProperty devPropertyObj = new DevProperty();

    public String getUserName() throws IOException {
        return devPropertyObj.getDevProperty().getProperty("login_username");
    }

    public String getPassword() throws IOException {
        return devPropertyObj.getDevProperty().getProperty("login_password");
    }

    public void loginFirstScreen(AppiumDriver driver) throws IOException {
      //  loginPage = new LoginPage(driver);
        loginPage.getBtnLoginButton().click();
        if (loginPage.getBtnLoginRadioButton().isDisplayed()) {
            loginPage.getBtnLoginRadioButton().click();
            loginPage.getUserName().sendKeys(getUserName());
            loginPage.getNext().click();
        }
    }

    public void loginSecScreen(AppiumDriver driver) throws IOException {
      //  loginSecPage = new LoginSecPage(driver);
        loginSecPage.getTxtPassword().sendKeys(getPassword());
    }
}
