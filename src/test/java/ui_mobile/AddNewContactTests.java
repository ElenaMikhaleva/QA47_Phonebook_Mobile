package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static utils.ContactFactory.*;

public class AddNewContactTests extends AppiumConfig {

    ContactsScreen contactsScreen;
    AddNewContactScreen addNewContactScreen;

    User qa_user = User.builder()
            .username("qa_user_qwerty@mail.com")
            .password("Password123!")
            .build();

    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver)
                .typeLoginForm(qa_user);
        contactsScreen = new ContactsScreen(driver);
        contactsScreen.clickBtnPlus();
        addNewContactScreen = new AddNewContactScreen(driver);
    }

    @Test
    public void addNewContactPositiveTest(){
        addNewContactScreen.typeContactForm(createPositiveContact());
        Assert.assertTrue(addNewContactScreen
                .validateMessageSuccess("Contact was added!"));
    }

    @Test
    public void addNewContactNegativeTest_wrongEmail(){
        addNewContactScreen.typeContactForm(createNegativeContact_wrongEmail(""));
    }

    @Test
    public void addNewContactNegativeTest_wrongPhone(){
        addNewContactScreen.typeContactForm(createNegativeContact_wrongPhone(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("Phone number must contain only"));
    }

    @Test
    public void addNewContactNegativeTest_wrongName(){
        addNewContactScreen.typeContactForm(createNegativeContact_wrongName("     "));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("must not be blank"));
    }
}
