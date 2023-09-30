import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class test_contact extends TestBase {
    @Test
    void sendMessage(){
        // Create and open page
        ContactPage contactPage = new ContactPage(page);
        contactPage.openContactPage();
        // Generate test data
        String email = generateRandomString(7) + "@test.com";
        String name = generateRandomString(7);
        String message = generateRandomString(100);
        // Fill form
        contactPage.fillForm(email,name,message);
        // Assert that test data is filled in
        assertThat(contactPage.contactEmailTB).hasValue(email);
        assertThat(contactPage.contactNameTB).hasValue(name);
        assertThat(contactPage.contactMessageBox).hasValue(message);

        // Create an onDialog handler to validate the dialog before accepting
        page.onDialog(dialog -> {
            assertEquals("alert", dialog.type());
            assertTrue(dialog.message().contains("Thanks for the message!!"));
            dialog.accept();
        });

        //send form
        contactPage.sendForm();


    }
}
