package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static step_definitions.Hooks.homePage;
import static step_definitions.Hooks.loginPage;

public class LoginStepDefinitions {



    @Given("user clicks on login")
    public void clickLogin(){
        homePage.loginBtn.click();
    }

    @When("user enters email and password")
    public void fillLoginForm(){
        loginPage.email.sendKeys("first@mail.com");
        loginPage.password.sendKeys("qwerty1234");
    }

    @And("clicks on login")
    public void clickLoginBtn(){
        loginPage.loginBtn.click();
    }

    @Then("user should login successfully")
    public void finishLogin(){
        Assert.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed());

    }
}
