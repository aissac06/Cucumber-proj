package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // path to your feature files
        glue = "steps",                             // package with your step definitions
        tags = "@requireslogin",                    // only run scenarios requiring login
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class runners {
}