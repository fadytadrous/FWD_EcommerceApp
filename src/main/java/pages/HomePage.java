package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "customerCurrency")
    public WebElement currencySelector;

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

    public void switchCurrency(String currencyName){
        Select currency = new Select(currencySelector);
        currency.selectByVisibleText(currencyName);
    }

    public boolean checkAllPricesChanged(){
        List<WebElement> prices = driver.findElements(By.cssSelector("div.prices>span"));
        Boolean allPricesChanged = true;

        for(int i = 0;i<=(prices.size()-1);i++) {
            if (prices.get(i).getText().contains("$")){
                allPricesChanged =false;
            };
        }
        return allPricesChanged;
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

        /*generating random number from the size of categories*/
        int randomNum = ThreadLocalRandom.current()
                .nextInt(0, categories.size()-1);
        WebElement randomCategory = categories.get(randomNum);

        action.moveToElement(randomCategory);
        /*Check if there's submenu using isEmpty flag in selenium*/
        boolean subMenu = !randomCategory.findElements(
                By.cssSelector("ul.sublist")).isEmpty();

        if (subMenu){
            action.moveToElement(randomCategory.findElement(
                    By.cssSelector("ul.sublist>li")));
            /*using innerText since getText gives unexpected result*/
            categorySelected = randomCategory
                    .findElement(By.cssSelector("ul.sublist>li>a"))
                    .getAttribute("innerText");
        }
        else {
            categorySelected = randomCategory.getText();
        }

        action.click().build().perform();

    }
}
