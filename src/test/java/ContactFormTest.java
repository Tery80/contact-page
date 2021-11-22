import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.ContactFormPage;
import pages.Form;

public class ContactFormTest {

    private BaseFunc base = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(ContactFormTest.class);

    @Test
    public void contactFormTest() {
        LOGGER.info("Open Contact Page");
        base.openContactPage();
        ContactFormPage contactPage = new ContactFormPage(base);
        contactPage.acceptAllCookies();
        contactPage.openForma();
        Form formPopUp = new Form(base);

        LOGGER.info("Check that Impossible to sent empty form");
        formPopUp.submit();

        formPopUp.verifyError("Lūdzu, aizpildiet lauku");

        LOGGER.info("Fill in form Correctly");
        formPopUp.fillField(" Vārds, uzvārds", "Ann Smith");
        formPopUp.fillField("Personas kods", "0123456");
        formPopUp.fillField("Kontakttālrunis", "987654321");
        formPopUp.fillField("E-pasta adrese", "abc@abc");
        formPopUp.fillField("Adrese", "John Doe str. 35");
        formPopUp.fillText("Komentāra/iebildumu būtība", "Some extra information about my Debts");
        formPopUp.fillDropDown("Kā vēlos saņemt atbildi", "Pasts");
//        formPopUp.submit(); //don't uncomment, otherwise request will be sent

//        formPopUp.verifyMessage("* Informejam, ka atbildi uz korekti");// Verify that correct information is displayed

        contactPage.close();
    }
}
