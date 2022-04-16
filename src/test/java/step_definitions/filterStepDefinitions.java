package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static step_definitions.Hooks.driver;

public class filterStepDefinitions {
    WebElement filter = null;

    @And("user selects specific category")
    public void selectShoes(){
        Actions action = new Actions(driver);

        WebElement Apparel = driver.findElements(
                By.cssSelector("div.header-menu>ul.notmobile>li")).get(2);
        action.moveToElement(Apparel);

        WebElement shoesCategory = Apparel.findElement(By.cssSelector("ul>li"));
        action.moveToElement(shoesCategory);
        action.click().build().perform();
    }

    @When("user filters with color")
    public void filterColor(){
        filter = driver.findElement(By.id("attribute-option-15"));
        filter.click();
    }

    @Then("results should be filtered")
    public void filteredResults(){
        Assert.assertTrue(filter.isSelected());
    }
}
