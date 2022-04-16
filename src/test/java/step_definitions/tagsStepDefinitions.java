package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static step_definitions.Hooks.driver;

public class tagsStepDefinitions {

    @When("user selects Camera tag")
    public void selectTag(){
        driver.findElement(By.linkText("camera")).click();
    }

    @Then("tag results should be displayed")
    public void assertTagResults(){
        String tagResults =  driver.findElement(By.cssSelector("div.page-title h1")).getText();
        Assert.assertEquals("Products tagged with 'camera'",tagResults);
    }
}
