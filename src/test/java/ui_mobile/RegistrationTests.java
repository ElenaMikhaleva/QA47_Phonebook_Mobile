package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.SplashScreen;

import static utils.UserFabric.*;

public class RegistrationTests extends AppiumConfig {

    AuthenticationScreen authenticationScreen;

    @BeforeMethod
    public void goToAuthScreen() {
        new SplashScreen(driver);
    }

    @Test
    public void registrationPositiveTest() {
        authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationForm(createUser());
        Assert.assertTrue( new ContactsScreen((driver)).validateContactsScreenOpen("Contact list"));
    }
}
