package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CreateTaskPage extends BasePage {
    @AndroidFindBy(id = "editTextTitre")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Title'")
    WebElement taskNameInput;

    @AndroidFindBy(id = "editTextNote")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Description'")
    WebElement taskDescInput;

    @AndroidFindBy(id = "action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    WebElement saveBtn;

    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void enterTaskName(String taskName) {
        clear(taskNameInput);
        sendText(taskNameInput, taskName);
    }

    public void enterTaskDesc(String TaskDesc) {
        clear(taskDescInput);
        sendText(taskDescInput, TaskDesc);
    }

    public void clickSaveBtn() {
        click(saveBtn);
    }
}
