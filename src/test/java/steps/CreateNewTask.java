package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateTaskPage;
import pages.TasksListPage;
import tests.BaseTest;

import java.net.MalformedURLException;

public class CreateNewTask extends BaseTest {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Given("Click Add new task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @And("Enter {string} and {string}")
    public void enterTaskNameAndTaskDesc(String taskName, String taskDesc) {
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }
    @When("Click Save")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
    }
    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        tearDown();
    }

}
