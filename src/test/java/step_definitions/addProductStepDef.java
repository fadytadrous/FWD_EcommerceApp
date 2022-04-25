package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static step_definitions.Hooks.driver;
import static step_definitions.Hooks.homePage;

public class addProductStepDef {

    @When("user adds mobile to cart")
    public void addProduct(){
        homePage.addMobileToCart().click();
    }

    @Then("product will be added to cart")
    public void CartIsFilled(){
        String notification = homePage.notification.getText();
        Assert.assertEquals(
                "The product has been added to your shopping cart", notification);
    }

    @When("user adds mobile to wishlist")
    public void addToWish(){
        homePage.addMobileToWish().click();
    }

    @Then("product will be added to wishlist")
    public void updateWishlist(){
        String notification = driver.findElement(By.cssSelector("p.content")).getText();
        Assert.assertEquals(
                "The product has been added to your wishlist", notification);

    }

    @When("user adds product to compare list")
    public void compareProduct(){
        homePage.addMobileToCompare().click();
    }

    @Then("product will be added to compare list")
    public void updateCompareList(){
        String notification = homePage.notification.getText();
        Assert.assertEquals(
                "The product has been added to your product comparison", notification);

    }
}
