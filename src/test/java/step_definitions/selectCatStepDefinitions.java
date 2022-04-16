package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static step_definitions.Hooks.driver;

public class selectCatStepDefinitions {
    String categorySelected = null;

    @When("user selects random category")
    public void selectRandomCat(){
        Actions action = new Actions(driver);

        List<WebElement> categories = driver.findElements(
                    By.cssSelector("div.header-menu>ul.notmobile>li"));
        int randomNum = ThreadLocalRandom.current().nextInt(0, categories.size());

        WebElement randomCategory = categories.get(randomNum);

        action.moveToElement(randomCategory);
        Boolean subMenu = randomCategory.findElement(
                        By.cssSelector("ul.sublist")).isDisplayed();
        if (subMenu){
            action.moveToElement(randomCategory.findElement(
                    By.cssSelector("ul.sublist>li")));
            categorySelected = randomCategory.findElement(
                    By.cssSelector("ul.sublist>li")).getText();
        }
        else {
            categorySelected = randomCategory.getText();
        }

        action.click().build().perform();

    }

    @Then("category results will be shown")
    public void assertCatResults(){
        Assert.assertEquals(categorySelected,
                driver.findElement(By.cssSelector("div.page-title>h1")).getText());
    }
}
