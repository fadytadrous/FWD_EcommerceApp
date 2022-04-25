package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "termsofservice")
    public WebElement terms;

    @FindBy(id = "checkout")
    public WebElement checkout;

    @FindBy(id = "BillingNewAddress_FirstName")
    public WebElement firstNameInput;

    @FindBy(id = "BillingNewAddress_LastName")
    public WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    public WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phone;
    @FindBy(css = "div#billing-buttons-container>button.new-address-next-step-button")
    public WebElement newAddress;
    @FindBy(css = "div#shipping-buttons-container>button")
    public WebElement continueShippingA;

    @FindBy(css = "div#shipping-method-buttons-container>button")
    public WebElement continueShippingM;

    @FindBy(css = "div#payment-method-buttons-container>button")
    public WebElement continuePaymentM;
    @FindBy(css = "div#payment-info-buttons-container>button")
    public WebElement continuePayment;
    @FindBy(css = "div#confirm-order-buttons-container>button")
    public WebElement confirmOrder;

    @FindBy(css = "div.order-completed>div.title>strong")
    public WebElement msg;

    public CheckoutPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
