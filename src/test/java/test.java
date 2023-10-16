import org.example.automation.Session;
import org.example.automation.utils.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    @Test
    public void testCase1(){
        WebDriver browserChrome = Session.get().webdriver();
        browserChrome.get("http://localhost/?controller=AuthController&action=check");
        browserChrome
                .findElement(By.xpath("//li[@id='item-4']/span[contains(text(),'Buttons')]"))
                .click();
        browserChrome
                .findElement(By.xpath("//button[text()= 'Click Me']"))
                .click();
        String pageText = browserChrome.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
        Assert.assertTrue(pageText.contains("You have done a dynamic click"));
        System.out.println(pageText);
        Sleep.sleep(5000);
    }

    @Test(testName = "DataBaseSELECTTest")
    public void testSelect() {
        try {
            PreparedStatement statement = Session.get().mysql().preparedStatement("SELECT * FROM links WHERE id=?;");
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                System.out.println(resultSet.getString("label"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
