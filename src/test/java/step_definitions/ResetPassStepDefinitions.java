package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ResetPassStepDefinitions {
    @And("clicks forgot password")
    public void forgetPass(){
        Hooks.driver.findElement(By.linkText("Forgot password?")).click();
    }

    @When("user enters his email")
    public void enterEmail(){
        Hooks.driver.findElement(By.id("Email")).sendKeys("first@mail.com");
    }

    @And("clicks recover")
    public void recoverMail(){
        Hooks.driver.findElement(By.cssSelector("div.buttons>button")).click();
    }

    @Then("user should receive recovery email")
    public void assertRecovery(){
        String msg = Hooks.driver.findElement(By.cssSelector("p.content")).getText();
        Assert.assertEquals("Email with instructions has been sent to you.",msg);
    }
}
