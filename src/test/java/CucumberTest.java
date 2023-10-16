import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test(groups = {"UI_tests"})
@CucumberOptions(

        features = "src/test/resources/cucumber",
        glue = {"org.example.automation.cucumber.steps"},
        plugin = {
                "pretty",
                "json:target/cucumber.json"
        }
)
public class CucumberTest extends AbstractTestNGCucumberTests {


}
