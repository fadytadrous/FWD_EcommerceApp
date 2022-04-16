package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static step_definitions.Hooks.driver;

public class addProductStepDef {

    @When("user adds mobile to cart")
    public void addProduct(){
        WebElement addBtn = driver.findElements(
                By.cssSelector("div.add-info>div.buttons>button:nth-child(1)")).get(2);
        addBtn.click();
    }

    @Then("product will be added to cart")
    public void CartIsFilled(){
        String notification = driver.findElement(By.cssSelector("p.content")).getText();
        Assert.assertEquals(
                "The product has been added to your shopping cart", notification);
    }

    @When("user adds mobile to wishlist")
    public void addToWish(){
        WebElement addBtn = driver.findElements(
                By.cssSelector("div.add-info>div.buttons>button:nth-child(3)")).get(2);
        addBtn.click();
    }

    @Then("product will be added to wishlist")
    public void updateWishlist(){
        String notification = driver.findElement(By.cssSelector("p.content")).getText();
        Assert.assertEquals(
                "The product has been added to your wishlist", notification);

    }
}
