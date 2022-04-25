package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomePage {
    WebDriver driver;
    public String categorySelected = null;

    @FindBy(className = "ico-login")
    public WebElement loginBtn;

    @FindBy(className = "ico-register")
    public WebElement registerBtn;

    @FindBy(css = "p.content")
    public WebElement notification;

    @FindBy(css = "form>button")
    public WebElement searchBtn;

    @FindBy(id = "topcartlink")
    public WebElement topCart;

    @FindBy(id = "small-searchterms")
    public WebElement searchBar;

    public HomePage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public WebElement addMobileToCart(){
        return driver.findElements(
                By.cssSelector("div.add-info>div.buttons>button:nth-child(1)"))
                .get(2);
    }
    public WebElement addMobileToWish(){
        return driver.findElements(
                        By.cssSelector("div.add-info>div.buttons>button:nth-child(3)"))
                .get(2);
    }
    public WebElement addMobileToCompare(){
        return driver.findElements(
                By.cssSelector("div.add-info>div.buttons>button:nth-child(2)"))
                .get(2);
    }

    public void selectShoesCategory(){
        Actions action = new Actions(driver);

        WebElement Apparel = driver.findElements(
                By.cssSelector("div.header-menu>ul.notmobile>li")).get(2);
        action.moveToElement(Apparel);

        WebElement shoesCategory = Apparel.findElement(By.cssSelector("ul>li"));
        action.moveToElement(shoesCategory);
        action.click().build().perform();
    }

    public void selectRandomCategory(){
        Actions action = new Actions(driver);

        List<WebElement> categories = driver.findElements(
                By.cssSelector("div.header-menu>ul.notmobile>li"));
        int randomNum = ThreadLocalRandom.current()
                .nextInt(0, categories.size());

        WebElement randomCategory = categories.get(randomNum);

        action.moveToElement(randomCategory);
        Boolean subMenu = !randomCategory.findElements(
                By.cssSelector("ul.sublist")).isEmpty();
        if (subMenu){
            action.moveToElement(randomCategory.findElement(
                    By.cssSelector("ul.sublist>li")));
            categorySelected = randomCategory.findElement(
                    By.cssSelector("ul.sublist>li")).getText();
        }
        else {
            categorySelected = randomCategory.getText();
        }

        action.click().build().perform();
    }
}
