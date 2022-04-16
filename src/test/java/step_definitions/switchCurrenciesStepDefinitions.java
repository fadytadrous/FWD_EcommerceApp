package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class switchCurrenciesStepDefinitions {

    @When("user switches currency")
    public void switchCurrency(){
        WebElement currencySelector = Hooks.driver.findElement(By.id("customerCurrency"));
        Select currency = new Select(currencySelector);
        currency.selectByVisibleText("Euro");
    }



    @Then("prices should be shown in that currency")
    public void assertPrices(){
        List<WebElement> prices = Hooks.driver.findElements(By.cssSelector("div.prices>span"));
        Boolean allPricesChanged = true;

        for(int i = 0;i<=(prices.size()-1);i++) {
            if (prices.get(i).getText().contains("$")){
                allPricesChanged =false;
            };
        }
        Assert.assertTrue(allPricesChanged);

    }
}
