package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseFunc {
    private WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(driver, 10);

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openContactPage() {
        driver.get("https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/");
    }

    public void clickButton(By locator)  {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void closeBrowser(){
        driver.close();
    }
}
