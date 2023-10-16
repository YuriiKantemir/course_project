package org.example.automation.cucumber.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.example.automation.app.LoginPage;
import org.example.automation.app.MainPage;
import org.example.automation.utils.Wait;
import org.testng.Assert;

public class CreateProjectSteps {
    MainPage mainPage= new MainPage();


    @Then("I set {string} field {string} on the popup")
    public void i_set_field_on_the_popup(String fieldName, String fieldValue) {
        mainPage.nameInput.setValue(fieldValue);
    }

    @Then("I check a title")
    public void i_check_a_title() {
        Wait.sleep(5000);
        Assert.assertEquals(MainPage.projectTitle.text(), "Test Project UI","Test project wasn't created");

    }
}
