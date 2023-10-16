package org.example.automation.app.ui;

import com.codeborne.selenide.SelenideElement;
import org.example.automation.app.LoginPage;
import org.example.automation.app.api.ProjectDataGenerator;
import org.testng.Assert;

public class UI {
    static LoginPage loginPage = new LoginPage();
    public static void UserLogin(){

        SelenideElement username = loginPage.username.setValue(ProjectDataGenerator.getUniqueUserName());
        SelenideElement password = loginPage.password.setValue("test01");
        loginPage.signinBtn.click();
        Assert.assertFalse(loginPage.isErrorMessagePresent(),"error");

    }
}
