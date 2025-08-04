package screens;

import dto.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen {

    public AuthenticationScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    WebElement inputEmail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    WebElement inputPassword;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    WebElement btnRegistration;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    WebElement btnLogin;

    public void typeRegistrationForm(User user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnRegistration.click();
    }
}
