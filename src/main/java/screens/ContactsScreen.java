package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsScreen extends BaseScreen {

    public ContactsScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView\n")
    WebElement textContactList;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
    WebElement btnAddNewContactPlus;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<WebElement> listContact;
    @FindBy(xpath = "//*[@text = 'YES']")
    WebElement btnYes;

    public boolean validateContactsScreenOpen(String text) {
        return textInElementPresent(textContactList, text, 10);
    }

    public void clickBtnPlus(){
        btnAddNewContactPlus.click();
    }

    public void scrollToLastContact() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        Actions action = new Actions(driver);
        boolean flag = true;
        while (flag){
            String first = listContact.get(listContact.size()-1).getText();
            System.out.println("first-->"+first);
            action.dragAndDrop(listContact.get(listContact.size()-1), listContact.get(0)).perform();
            String second = listContact.get(listContact.size()-1).getText();
            System.out.println("second-->"+second);
            if(first.equals(second))
                flag = false;
        }
    }
    public void clickToLastContact(){
        listContact.get(listContact.size()-1).click();
    }
    public void swipeRightToLeft(){
        int width = driver.manage().window().getSize().getWidth();
        Actions actions = new Actions(driver);
        actions.moveToElement(listContact.get(0), -width/100*48, 0)
                .clickAndHold()
                .moveToElement(listContact.get(0), width/100*48, 0)
                .release()
                .perform();
    }
    public EditContactScreen swipeLeftToRight(){
        int width = driver.manage().window().getSize().getWidth();
        Actions actions = new Actions(driver);
        actions.moveToElement(listContact.get(0), width/100*48, 0)
                .clickAndHold()
                .moveToElement(listContact.get(0), -width/100*48, 0)
                .release()
                .perform();
        return new EditContactScreen(driver);
    }
    public void clickBtnYes(){
        btnYes.click();
    }
}
