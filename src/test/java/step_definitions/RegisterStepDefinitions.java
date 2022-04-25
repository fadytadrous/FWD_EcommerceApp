package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import static step_definitions.Hooks.homePage;
import static step_definitions.Hooks.registerPage;


public class RegisterStepDefinitions {


    @Given("user clicks on register")
    public void clickRegister(){
        homePage.registerBtn.click();
    }

    @When("user enters valid mandatory fields")
    public void fillRegistrationForm(){
        registerPage.firstName.sendKeys("first");
        registerPage.lastName.sendKeys("last");
        registerPage.email.sendKeys("first@mail.com");
        registerPage.password.sendKeys("qwerty1234");
        registerPage.confirmPassword.sendKeys("qwerty1234");
    }

    @And("clicks on register")
    public void clickRegisterBtn(){
        registerPage.registerBtn.click();
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
