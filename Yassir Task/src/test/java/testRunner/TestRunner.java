package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue= "stepDefs",
        plugin = {"pretty", "html:Reports/test-report.html"},
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
