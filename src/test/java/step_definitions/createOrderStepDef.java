package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static step_definitions.Hooks.*;

public class createOrderStepDef {

    @And("proceeds to checkout")
    public void checkout(){
        homePage.topCart.click();
        checkoutPage.terms.click();
        checkoutPage.checkout.click();
    }

    @And("fills address details")
    public void setAddress(){
        WebElement firstNameInput = checkoutPage.firstNameInput;
        if (firstNameInput.isDisplayed()){
            /*Fill user data/address */
            firstNameInput.sendKeys("test");
            driver.findElement(By.id("BillingNewAddress_LastName"))
                    .sendKeys("user");
            checkoutPage.email.clear();
            checkoutPage.email.sendKeys("test@gmail.com");


            Select countryList = new Select(checkoutPage.country);
            countryList.selectByVisibleText("Algeria");

            checkoutPage.city.sendKeys("city");
            checkoutPage.address.sendKeys("18 fadel street");
            checkoutPage.zip.sendKeys("23423");
            checkoutPage.phone.sendKeys("0123123334");

        }

        checkoutPage.newAddress.click();
        if(checkoutPage.continueShippingA.isDisplayed()){
            checkoutPage.continueShippingA.click();
        }
        checkoutPage.continueShippingM.click();
        checkoutPage.continuePaymentM.click();
        checkoutPage.continuePayment.click();
        checkoutPage.confirmOrder.click();
    }

    @Then("successful Order will be created")
    public void checkOrderCreated(){
        String msg = checkoutPage.msg.getText();

        Assert.assertEquals("Your order has been successfully processed!",msg);
    }
}
