package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefinitions {

    @Given("user clicks on login")
    public void clickLogin(){
        Hooks.driver.findElement(By.className("ico-login")).click();
    }

    @When("user enters email and password")
    public void fillLoginForm(){
            Hooks.driver.findElement(By.id("Email")).sendKeys("first@mail.com");
        Hooks.driver.findElement(By.id("Password")).sendKeys("qwerty1234");
    }

    @And("clicks on login")
    public void clickLoginBtn(){
        Hooks.driver.findElement(By.cssSelector("form>div.buttons>button")).click();
    }

    @Then("user should login successfully")
    public void finishLogin(){
        Assert.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed());

    }
}
