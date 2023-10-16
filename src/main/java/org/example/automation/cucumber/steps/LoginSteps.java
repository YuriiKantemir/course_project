package org.example.automation.cucumber.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.automation.Session;
import org.example.automation.app.LoginPage;
import org.example.automation.app.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.stream.Collectors;

public class LoginSteps {

    LoginPage loginPage;

    @Given("I navigate to login page")
    public void iNavigateToLoginPage() {
        //IndexPage indexPage = new IndexPage();
        //loginPage = indexPage.goToLoginPage();
        loginPage = new LoginPage();
    }

    @When("I set {string} field value {string} on login page")
    public void iSetFieldValue(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "username":
                loginPage.username.val(fieldValue);
                break;
            case "password":
                loginPage.password.val(fieldValue);
                break;
            default:
                throw new RuntimeException("Invalid field name \"" + fieldName + "\"");
        }
    }

    @Then("error message is present on login page")
    public void errorMessageIsPresentOnLoginPage() {
        Assert.assertTrue(
                loginPage.isErrorMessagePresent(),
                "Error messages are present: \n" +
                        loginPage.errorMessage
                                .stream()
                                .map(WebElement::getText)
                                .collect(Collectors.joining("\n"))
                        + "\n"
        );
    }

    @Then("error message is not present on login page")
    public void errorMessageIsNotPresentOnLoginPage() {
        Assert.assertFalse(
                loginPage.isErrorMessagePresent(),
                "Error messages are present: \n" +
                        loginPage.errorMessage
                                .stream()
                                .map(WebElement::getText)
                                .collect(Collectors.joining("\n"))
                        + "\n"
        );
    }

    @Then("I still on login page")
    public void i_still_on_login_page(){
        Assert.assertEquals(LoginPage.getCurrentURL(),loginPage.errorUrl,"You are not on login page");

    }

    @Then("I'm on the main page")
    public void i_m_on_the_main_page(){
        Assert.assertEquals(LoginPage.getCurrentURL(), MainPage.mainPageUrl,"You are not on Main page");
        //Session.get().webdriver().quit();

    }

}
