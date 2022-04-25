package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static step_definitions.Hooks.homePage;
import static step_definitions.Hooks.loginPage;

public class ResetPassStepDefinitions {
    @And("clicks forgot password")
    public void forgetPass(){
        loginPage.forgotPass.click();
    }

    @When("user enters his email")
    public void enterEmail(){
        loginPage.email.sendKeys("first@mail.com");
    }

    @And("clicks recover")
    public void recoverMail(){
        loginPage.recoverBtn.click();
    }

    @Then("user should receive recovery email")
    public void assertRecovery(){
        String msg = homePage.notification.getText();
        Assert.assertEquals(
                "Email with instructions has been sent to you.", msg);
    }
}
