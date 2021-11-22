package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseFunc {
    private WebDriver driver;
    WebElement element;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openContactPage() {
//        Properties prop = new Properties();
//        String fileName = "config.properties";
//        try (FileInputStream fis = new FileInputStream(fileName)) {
//            prop.load(fis);
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        }
//        String link = prop.getProperty("webPage");
//        driver.get(link);
        driver.get("https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/");
    }

    public void clickButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
