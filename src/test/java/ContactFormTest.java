import core.BaseFunc;
import pages.ContactFormPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

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
        contactPage.submit();

        //check that SAZINIETIES AR MUMS present
        //Check that Forms present
        // click Forma button
     // fill in Vards as !@#$
        // pk test
        //error jQuery Validate Unobtrusive has not been loaded & is required for Umbraco Forms.
//email is check for @ only
        //no checks for PK garums
        //
    }
}
