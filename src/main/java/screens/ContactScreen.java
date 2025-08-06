package screens;

import dto.Contact;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactScreen extends BaseScreen {
    public ContactScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/nameTxt")
    WebElement nameTxt;
    @FindBy(id = "com.sheygam.contactapp:id/lastNameTxt")
    WebElement lastNameTxt;
    @FindBy(id = "com.sheygam.contactapp:id/emailTxt")
    WebElement emailTxt;
    @FindBy(id = "com.sheygam.contactapp:id/phoneTxt")
    WebElement phoneTxt;
    @FindBy(id = "com.sheygam.contactapp:id/addressTxt")
    WebElement addressTxt;
    @FindBy(id = "com.sheygam.contactapp:id/descTxt")
    WebElement descTxt;

    public Contact getContact() {
        System.out.println("=========================="+nameTxt.getText());
        return Contact.builder()
                .name(nameTxt.getText())
                .lastName(lastNameTxt.getText())
                .email(emailTxt.getText())
                .phone(phoneTxt.getText())
                .address(addressTxt.getText())
                .description(descTxt.getText())
                .build();
    }
}