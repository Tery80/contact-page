package pages;

import core.BaseFunc;
import org.openqa.selenium.By;

public class ContactFormPage {
    private BaseFunc base;


    public ContactFormPage(BaseFunc base) {
        this.base = base;
    }

    public void acceptAllCookies() throws InterruptedException {
        base.clickButton(By.id("onetrust-accept-btn-handler"));
    }

    public void openForma() throws InterruptedException {
        base.clickButton(By.xpath("//a[@title='Iebildumu un komentāru forma']"));
    }

}
