import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class test_about_us extends TestBase {
    @Test
    void watchVideo(){
        //Go to page
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About us"));
        navigationLink.click();


        Locator playButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Play"));
        Locator closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));


        //Create an onDialog handler to validate the dialog before accepting
        page.onDialog(dialog -> {
            assertEquals("alert", dialog.type());
            assertTrue(dialog.message().contains("Thanks for the message!!"));
            dialog.accept();
        });

        //send form
        playButton.click();


    }
}
