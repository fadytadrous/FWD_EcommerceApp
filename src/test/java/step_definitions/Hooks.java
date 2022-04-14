package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {
    static WebDriver driver = null;

    @Before
    public void openBrowser(){
//        System.setProperty("webdriver.chrome.driver", "C://webdriver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, 9);
//        wait.until (ExpectedConditions.urlToBe(""));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
