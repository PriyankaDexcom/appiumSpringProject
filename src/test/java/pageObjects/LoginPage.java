package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='mat-radio-3-input']")
    public MobileElement btnLoginRadioButton;

    @AndroidFindBy(id = "id_login_button")
    public MobileElement btnLoginButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='mat-input-0']")
    private MobileElement userName;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='login_id_btn']")
    private MobileElement btnNext ;

    // Constructor to initialize the driver
    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement getBtnLoginRadioButton() {
        return btnLoginRadioButton;
    }

    public MobileElement getBtnLoginButton() {
        return btnLoginButton;
    }

    public MobileElement getUserName() {
        return userName;
    }

    public MobileElement getNext() {
        return btnNext;
    }

}
