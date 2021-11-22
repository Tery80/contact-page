package core;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.function.Function;

class CheckIfReallyClickable implements Function<WebDriver, WebElement> {

    private Function<WebDriver, WebElement> wrapped;

    public CheckIfReallyClickable(By locator) {
        this.wrapped = ExpectedConditions.elementToBeClickable(locator);
    }

    public WebElement apply(WebDriver driver) {
        WebElement e = wrapped.apply(driver);
        if (e != null) {
            try {
                e.click();
            } catch (ElementClickInterceptedException ex) {
                e = null;
            }
        }
        return e;
    }
}

public class BaseFunc {

    private WebDriver driver;
    private final WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
    }

    public void openContactPage() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
        }
        String link = properties.getProperty("webPage");
        driver.get(link);
    }

    public void clickButton(By locator) {
        wait.until(new CheckIfReallyClickable(locator));
    }

    public String getMessage(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement getElementSafely(By locator) {
        return driver.findElement(locator);
    }

    public void enterValue(WebElement element, String text) {
        element.click();
        element.sendKeys(text);
    }

    public Boolean isPresent(String text) {
        return driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size() > 0;
    }

    public void closeBrowser() {
        driver.close();
    }
}