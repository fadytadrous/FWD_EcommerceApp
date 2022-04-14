package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class RegisterStepDefinitions {


    @Given("user clicks on register")
    public void clickRegister(){
        Hooks.driver.findElement(By.className("ico-register")).click();
    }

    @When("user enters valid mandatory fields")
    public void fillRegistrationForm(){
        Hooks.driver.findElement(By.id("FirstName")).sendKeys("first");
        Hooks.driver.findElement(By.id("LastName")).sendKeys("last");
        Hooks.driver.findElement(By.id("Email")).sendKeys("first@mail.com");
        Hooks.driver.findElement(By.id("Password")).sendKeys("qwerty1234");
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys("qwerty1234");
    }

    @And("clicks on register")
    public void clickRegisterBtn(){
        Hooks.driver.findElement(By.id("register-button")).click();
    }

    @Then("user should register successfully")
    public void finishRegister(){
        String msg = Hooks.driver.findElement(By.className("result")).getText();
        Assert.assertEquals("Your registration completed", msg);
        //TESTNG: needs object, with soft assertion we could do multiple assertions
        // SoftAssert soft = new SoftAssert();
        // soft.assertTrue (Hooks.driver.findElement(By.partiallinkText("Your registration complet")).isDisplayed ());
        // soft.assertAll();
    }


}
