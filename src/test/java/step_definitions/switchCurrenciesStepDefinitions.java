package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static step_definitions.Hooks.homePage;

public class switchCurrenciesStepDefinitions {

    @When("user switches currency")
    public void switchCurrency(){
        homePage.switchCurrency("Euro");
    }



    @Then("prices should be shown in that currency")
    public void assertPrices(){

        Assert.assertTrue(homePage.checkAllPricesChanged());

    }
}
