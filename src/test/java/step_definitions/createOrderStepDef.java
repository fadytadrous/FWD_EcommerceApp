package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static step_definitions.Hooks.driver;

public class createOrderStepDef {

    @And("proceeds to checkout")
    public void checkout(){
        driver.findElement(By.id("topcartlink")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
    }

    @And("fills address details")
    public void setAddress(){
        WebElement firstNameInput = driver.findElement(By.id(
                    "BillingNewAddress_FirstName"));
        if (firstNameInput.isDisplayed()){
            /*Fill user data/address */
            firstNameInput.sendKeys("test");
            driver.findElement(By.id("BillingNewAddress_LastName"))
                    .sendKeys("user");
            driver.findElement(By.id("BillingNewAddress_Email"))
                    .clear();
            driver.findElement(By.id("BillingNewAddress_Email"))
                    .sendKeys("test@gmail.com");

            WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select countryList = new Select(country);
            countryList.selectByVisibleText("Algeria");

            driver.findElement(By.id("BillingNewAddress_City"))
                    .sendKeys("city");
            driver.findElement(By.id("BillingNewAddress_Address1"))
                    .sendKeys("18 fadel street");
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode"))
                    .sendKeys("23423");
            driver.findElement(By.id("BillingNewAddress_PhoneNumber"))
                    .sendKeys("0123123334");

        }

        driver.findElement(By.cssSelector(
                "div#billing-buttons-container>button.new-address-next-step-button"))
                .click();
        if(driver.findElement(By.cssSelector("div#shipping-buttons-container>button"))
                .isDisplayed()){
            driver.findElement(By.cssSelector("div#shipping-buttons-container>button"))
                    .click();
        }

        driver.findElement(By.cssSelector("div#shipping-method-buttons-container>button"))
                .click();
        driver.findElement(By.cssSelector("div#payment-method-buttons-container>button"))
                .click();
        driver.findElement(By.cssSelector("div#payment-info-buttons-container>button"))
                .click();
        driver.findElement(By.cssSelector("div#confirm-order-buttons-container>button"))
                .click();
    }

    @Then("successful Order will be created")
    public void checkOrderCreated(){
        String msg = driver.findElement(By.
                        cssSelector("div.order-completed>div.title>strong")).getText();

        Assert.assertEquals("Your order has been successfully processed!",msg);
    }
}
