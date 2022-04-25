package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
    WebDriver driver;

    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id = "register-button")
    public WebElement registerBtn;

    public registerPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
