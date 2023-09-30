import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test_sign_up extends TestBase{
    @Test
    void newSignUp() {
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign up"));
        navigationLink.click();
        String username = generateRandomString(7);
        String password = generateRandomString(7);

        Locator tbUsername = page.locator("#sign-username");
        Locator tbPassword = page.locator("#sign-password");
        Locator signUpButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up"));
        Locator closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        //Populate form
        tbUsername.fill(username);
        tbPassword.fill(password);

        //Assertion
        assertThat(tbUsername).hasValue(username);
        assertThat(tbPassword).hasValue(password);

        page.onDialog(dialog -> {
            assertEquals("alert", dialog.type());
            assertTrue(dialog.message().contains("Sign up successful."));

            dialog.accept();
        });

        signUpButton.click();

    }
}
