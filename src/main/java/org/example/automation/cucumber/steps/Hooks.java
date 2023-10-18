package org.example.automation.cucumber.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.example.automation.Config;
import org.example.automation.Session;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void before(Scenario scenario) {
        this.wd().get(String.format("http://%s:%s",
                Config.HTTP_BASE_HOST.value,
                Config.HTTP_BASE_PORT.value
        ));
        WebDriverRunner.setWebDriver(this.wd());
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.getStatus() == Status.FAILED) {
            // Take screenshot
            // Attach to report
        }
        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
