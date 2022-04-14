package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class searchProductsStepDefinitions {

    @Given("user is logged in")
    public void login(){
        LoginStepDefinitions loginStepDefinition = new LoginStepDefinitions();
        loginStepDefinition.clickLogin();
        loginStepDefinition.fillLoginForm();
        loginStepDefinition.clickLoginBtn();
        loginStepDefinition.finishLogin();

    }

    @When("user searches for a product")
    public void searchForProduct(){
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys("Nokia");
        Hooks.driver.findElement(By.cssSelector("form>button")).click();

    }

    @Then("user should see search results")
    public void assertResults(){
        String res = Hooks.driver.findElement(By.cssSelector("h2>a")).getText();
        Assert.assertTrue(res.contains("Nokia"));
    }
}
