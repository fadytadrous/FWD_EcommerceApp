package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(id = "attribute-option-15")
    public WebElement colorFilter;

    @FindBy(css = "h2>a")
    public WebElement searchResults;

    @FindBy(css = "div.page-title>h1")
    public WebElement searchResultsTitle;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement tagByLinkText(String linkTxt){
        return driver.findElement(By.linkText(linkTxt));
    }
    public String getSearchResults(){
        return searchResults.getText();
    }
}
