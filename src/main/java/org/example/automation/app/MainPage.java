package org.example.automation.app;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.automation.base.BaseSelenidePage;

public class MainPage extends BaseSelenidePage {

    public static String mainPageUrl = "http://localhost/dashboard";
    static final public SelenideElement dashboardBtn    = Selenide.$x("//a[@title='Dashboard']");
    //static final public SelenideElement checkWarningMessage = Selenide.$x("//p[@class ='form-help']");
    static final public SelenideElement nameInput = Selenide.$x("//input[@id ='form-name']");
    static final public SelenideElement saveButton = Selenide.$x("//button[@type ='submit']");
    static final public SelenideElement projectTitle = Selenide.$x("//span[@class ='title']");
    static final public SelenideElement addNewPrj = Selenide.$x("//div[@class='page-header']//a[contains(text(), 'New personal project')]");
    static final public SelenideElement taskDropdownMenu = Selenide.$x("//a[@class='dropdown-menu action-menu']");
    static final public SelenideElement inputTaskName = Selenide.$x("//input[@id='form-title']");
//    static final public SelenideElement taskMenu = Selenide.$x("//a[@class='dropdown-menu-link-icon dropdown-menu']//i[@class='fa fa-caret-down']");  //div[@class='dropdown']//a[@class='dropdown-menu dropdown-menu-link-icon']//a[@strong[matches(., '#\d')]]
//    static final public SelenideElement closeTaskButton = Selenide.$x("//ul[@class = 'dropdown-submenu-open']//a[@class='js-modal-confirm']//i[@class='fa fa-times fa-fw js-modal-confirm']");
//    static final public SelenideElement taskMenu = Selenide.$x("//div[@class='dropdown']//a[@class='dropdown-menu dropdown-menu-link-icon']//a[@strong[matches(., '#\\d')]]");
    static final public SelenideElement closeTaskButton = Selenide.$x("//div[@class = 'sidebar sidebar-icons']//a[@class='js-modal-confirm']//i[@class='fa fa-times fa-fw js-modal-confirm']");
    static final public SelenideElement confirmCloseTaskButton = Selenide.$x("//button[@id='modal-confirm-button']");
    static final public SelenideElement taskStatus = Selenide.$x("//ul[@class='no-bullet']//span[contains(text(), 'closed')]");
    static final public SelenideElement openTaskComment = Selenide.$x("//summary[contains(text(), 'Comments')]");
    static final public SelenideElement taskCommentTextField = Selenide.$x("//textarea[@name = 'comment']");


    static final public SelenideElement getProjectLink(String projectId){
        return Selenide.$x("//span[@class='table-list-title ']//a[@href = '/board/" + projectId + "']");
    }
    static final public SelenideElement createTaskBtn(String projectId){
        return Selenide.$x("//div[@id='dropdown']//a[@href='/project/" + projectId + "/task/create']");
    }
    static final public SelenideElement getTaskName(String taskName){
        return Selenide.$x("//a[text() ='"+ taskName +"']");
    }
    static final public SelenideElement getTaskComment(String taskName){
        return Selenide.$x("//p[text() ='"+ taskName +"']");
    }

}
