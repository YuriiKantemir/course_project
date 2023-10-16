package org.example.automation.app;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.automation.Config;
import org.example.automation.Session;
import org.example.automation.base.BasePage;
import org.example.automation.base.BaseSelenidePage;
import org.example.automation.utils.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static java.awt.SystemColor.window;

public class LoginPage extends BaseSelenidePage {

    final public SelenideElement username    = Selenide.$x("//input[@id='form-username']");
    final public SelenideElement password = Selenide.$x("//input[@id='form-password']");
    final public SelenideElement signinBtn = Selenide.$x("//button[@type='submit']");

    final public ElementsCollection errorMessage = Selenide.$$x("//*[@class='alert alert-error']");
    public String errorUrl = new String("http://localhost/?controller=AuthController&action=check");

    public SelenideElement username(){return username;}
    public SelenideElement password(){return password;}
    public SelenideElement signinBtn(){return signinBtn;}


    public boolean isErrorMessagePresent() {
        Wait.waitWhilePageIsLoading();
        try {
            errorMessage.shouldBe(
                    CollectionCondition.allMatch("exist", WebElement::isDisplayed),
                    Duration.ofSeconds(5)
            );
        } catch (Throwable e) { /* Ignore */ }

        return !errorMessage.isEmpty();
    }
    public static String getCurrentURL() {
        JavascriptExecutor js = (JavascriptExecutor) Session.get().webdriver();
        String currentURL = (String) js.executeScript("return window.location.href;");
        //System.out.println("The current URL is: " + currentURL);
        return currentURL;
    }



}
