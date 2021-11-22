package pages;

import core.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Form {
    private BaseFunc base;

    public Form(BaseFunc base) {
        this.base = base;
    }

    public void submit() {
        base.clickButton(By.xpath("//input[@type='submit']"));
    }

    public void verifyError(String error) {
        String errorMsg = base.getMessage(By.xpath("//span[contains(@id, 'error')]"));
        Assertions.assertEquals(error, errorMsg);
    }

    public void fillField(String fieldName, String info) {
        WebElement textarea = base.getElementSafely(By.xpath("//*[contains(text(),'" + fieldName + "')]//..//input"));
        base.enterValue(textarea, info);
    }

    public void fillText(String fieldName, String info) {
        WebElement textarea = base.getElementSafely(By.xpath("//*[contains(text(),'" + fieldName + "')]//..//textarea"));
        base.enterValue(textarea, info);
    }

    public void fillDropDown(String fieldName, String text) {
        WebElement textarea = base.getElementSafely(By.xpath("//*[contains(text(),'" + fieldName + "')]//..//select"));
        textarea.click();
        base.getElementSafely(By.xpath("//*[text()='" + text + "']")).click();
    }

    public void verifyMessage(String text) {
        Assertions.assertTrue(base.isPresent(text));
    }
}
