package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginSecPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private MobileElement txtPassword;

    public LoginSecPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement getTxtPassword() {
        return txtPassword;
    }

}
