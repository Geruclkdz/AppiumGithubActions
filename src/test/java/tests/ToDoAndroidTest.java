package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateTaskPage;
import pages.TasksListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDoAndroidTest extends BaseTest {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "Tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJsonData(
                System.getProperty("user.dir") + "/data/TasksData.json",
                "Tasks Data",
                2
        );
    }

    @Test(dataProvider = "Tasks data")
    public void testAddTask(String taskName, String taskDesc) throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        createTaskPage.hideAndroidKeyboard();
        createTaskPage.clickSaveBtn();
    }
}
