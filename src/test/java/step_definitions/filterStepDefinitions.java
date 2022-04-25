package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static step_definitions.Hooks.*;

public class filterStepDefinitions {

    @And("user selects specific category")
    public void selectShoes(){
        homePage.selectShoesCategory();
    }

    @When("user filters with color")
    public void filterColor(){
        searchPage.colorFilter.click();
    }

    @Then("results should be filtered")
    public void filteredResults(){
        Assert.assertTrue(searchPage.colorFilter.isSelected());
    }
}
