package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static step_definitions.Hooks.homePage;
import static step_definitions.Hooks.searchPage;

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
        homePage.searchBar.sendKeys("Nokia");
        homePage.searchBtn.click();
    }

    @Then("user should see search results")
    public void assertResults(){
        Assert.assertTrue(searchPage.getSearchResults().contains("Nokia"));
    }
}
