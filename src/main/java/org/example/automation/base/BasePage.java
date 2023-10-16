package org.example.automation.base;

import org.example.automation.Session;
import org.openqa.selenium.WebDriver;

abstract public class BasePage
{
    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
