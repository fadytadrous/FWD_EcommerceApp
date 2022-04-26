package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\java\\features",
        glue = "step_definitions",
        /* uncomment tags if you want to run a smoke test*/
        //tags = "@smokeTest",
        plugin = {"pretty", "html:target/cucumber-reports.html" },
        monochrome = true

)

public class testRunner {
}
