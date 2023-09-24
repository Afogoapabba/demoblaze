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
        //Go to page
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact"));
        navigationLink.click();
        String email = "test@test.com";
        String name = "Tommy Test";
        String message = "The quick brown fox jumps over the lazy dog";

        //Create Locators
        Locator contactEmailTB = page.locator("#recipient-email");
        Locator contactNameTB = page.locator("#recipient-name");
        Locator contactMessageBox = page.locator("#message-text");
        Locator sendMsgButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send message"));
        Locator closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));

        //Populate elements
        contactEmailTB.fill(email);
        contactNameTB.fill(name);
        contactMessageBox.fill(message);

        //Create an onDialog handler to validate the dialog before accepting
        page.onDialog(dialog -> {
            assertEquals("alert", dialog.type());
            assertTrue(dialog.message().contains("Thanks for the message!!"));
            dialog.accept();
        });

        //send form
        sendMsgButton.click();


    }
}
