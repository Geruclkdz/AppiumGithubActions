package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateTaskPage;
import pages.TasksListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDoIOSTest extends BaseTest{

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
        iOS_setUp("10000", "iPhone 16", "28795298-A7A4-4CBD-9939-1E6C96BFBA35", 8200);
        tasksListPage  = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        createTaskPage.clickSaveBtn();
    }

    @Test(dataProvider = "Tasks data")
    public void testAddTask2(String taskName, String taskDesc) throws MalformedURLException {
        iOS_setUp("10001", "iPhone 16 Pro", "B6E0E739-C45B-482E-AF3E-A56924B1CE36", 8100);
        tasksListPage  = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
        createTaskPage.clickSaveBtn();
    }
}
