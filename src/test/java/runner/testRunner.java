package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\java\\features",
        glue = "step_definitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports" },
        monochrome = true

)

public class testRunner {
}
