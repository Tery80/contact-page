package pages;

import core.BaseFunc;
import org.openqa.selenium.By;

public class ContactFormPage {
    private BaseFunc base;


    public ContactFormPage(BaseFunc base) {
        this.base = base;
    }

    public void acceptAllCookies() {
        base.clickButton(By.id("onetrust-accept-btn-handler"));
    }

    public void openForma() {
        base.clickButton(By.xpath("//a[@title='Iebildumu un komentāru forma']"));
    }

    public void close() {
        base.closeBrowser();
    }

}
