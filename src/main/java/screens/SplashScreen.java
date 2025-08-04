package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{

    public SplashScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/version_text")
    WebElement versionApp;

    public boolean validateVersionApp(String text) {
        return textInElementPresent(versionApp, text, 10);
    }
}
