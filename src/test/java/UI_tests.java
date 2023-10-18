import org.example.automation.app.LoginPage;
import org.example.automation.app.MainPage;
import org.example.automation.app.api.ProjectDataGenerator;
import org.example.automation.base.BaseGUITest;
import org.example.automation.app.ui.UI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.automation.utils.Wait;

public class UI_tests extends BaseGUITest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();


    @Test(groups = {"UI_tests"})
    public void userCreateTask() {

        UI userLogin = new UI();
        userLogin.UserLogin();
        mainPage.getProjectLink(projectId).click();
        mainPage.taskDropdownMenu.click();
        mainPage.createTaskBtn(projectId).click();
        mainPage.inputTaskName.setValue(ProjectDataGenerator.getUniqueTaskName());
        mainPage.saveButton.click();
        Assert.assertEquals(MainPage.getTaskName(ProjectDataGenerator.getUniqueTaskName()).text(),
                ProjectDataGenerator.getUniqueTaskName(),"Task doesn't exist");

    }
    @Test(groups = {"UI_tests"}, dependsOnMethods = "userCreateTask")
    public void userAddCommentToTask(){
        UI userLogin = new UI();
        userLogin.UserLogin();
        mainPage.getProjectLink(projectId).click();
        mainPage.getTaskName(ProjectDataGenerator.getUniqueTaskName()).click();
        System.out.println(projectId);
        mainPage.openTaskComment.click();
        mainPage.taskCommentTextField.setValue(ProjectDataGenerator.getUniqueComment());
        mainPage.saveButton.click();
        Wait.sleep(5000);
        Assert.assertEquals(MainPage.getTaskComment(ProjectDataGenerator.getUniqueComment()).text(),
                ProjectDataGenerator.getUniqueComment(),"Task comment doesn't created");
    }
    @Test(groups = {"UI_tests"}, dependsOnMethods = "userAddCommentToTask")
    public void userCloseProject(){
        UI userLogin = new UI();
        userLogin.UserLogin();
        mainPage.getProjectLink(projectId).click();
        mainPage.getTaskName(ProjectDataGenerator.getUniqueTaskName()).click();
        mainPage.closeTaskButton.click();
        mainPage.confirmCloseTaskButton.click();
        Assert.assertNotEquals(MainPage.taskStatus,"closed","Task wasn't deleted");
    }


}
