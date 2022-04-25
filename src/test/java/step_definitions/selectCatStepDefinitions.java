package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static step_definitions.Hooks.*;

public class selectCatStepDefinitions {

    @When("user selects random category")
    public void selectRandomCat(){
        homePage.selectRandomCategory();
    }

    @Then("category results will be shown")
    public void assertCatResults(){
        Assert.assertEquals(homePage.categorySelected,
                searchPage.searchResultsTitle.getText());
    }
}
