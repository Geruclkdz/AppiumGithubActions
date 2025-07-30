package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TasksListPage extends BasePage {

    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "plus.circle")
    WebElement addTaskBtn;

    public TasksListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickAddTaskBtn() {
        click(addTaskBtn);
    }
}
