package org.example.automation.cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonSteps {

    //@When("I click {string} button")
    @When("^I click \"(.+)\" button$")
    public void iClickButton(String buttonText) {
        Selenide.$x("//button[text()='" + buttonText + "']").shouldBe(Condition.visible).click();
    }

    @When("^I click top menu \"(.+)\" link$")
    public void iClickTopMenuLink(String linkText) {
        Selenide.$x("//div[@class='page-header']//a[contains(text(), '" + linkText + "')]").click();
        System.out.println(linkText);
    }

    @And("I click Dashboard button")
    public void iClickDashboardButton() {
        //Selenide.$x("//a[@title='" + title + "']").click();
        Selenide.$x("//a[@href='/dashboard']").click();
    }


}
