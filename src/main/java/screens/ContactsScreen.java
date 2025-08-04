package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsScreen extends BaseScreen {

    public ContactsScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView\n")
    WebElement textContactList;

    public boolean validateContactsScreenOpen(String text) {
        return textInElementPresent(textContactList, text, 10);
    }

}
