package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static step_definitions.Hooks.driver;
import static step_definitions.Hooks.searchPage;

public class tagsStepDefinitions {

    @When("user selects Camera tag")
    public void selectTag(){
        searchPage.tagByLinkText("camera").click();
    }

    @Then("tag results should be displayed")
    public void assertTagResults(){
        String tagResults =  searchPage.searchResultsTitle.getText();
        Assert.assertEquals("Products tagged with 'camera'",tagResults);
    }
}
