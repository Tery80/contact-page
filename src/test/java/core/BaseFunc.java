package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseFunc {
    private WebDriver driver;
    private final WebDriverWait wait;
    WebElement element;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openContactPage() {
        driver.get("https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/");
    }

    public void clickButton(By locator) throws InterruptedException {
        Thread.sleep(5000);
        element = driver.findElement(locator);
        element.click();
    }

    public String getMessage(By locator) {
        element = driver.findElement(locator);
        return element.getText();
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
