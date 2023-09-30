import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
public class test_login extends TestBase {
    @Test
    void checkForm() {
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in"));
        navigationLink.click();
        String username = "admin";
        String password = "Password123";

        Locator tbUsername = page.locator("#loginusername");
        Locator tbPassword = page.locator("#loginpassword");
        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
        Locator closeButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close"));
        //Populate form
        tbUsername.fill(username);
        tbPassword.fill(password);

        //Assertion
        assertThat(tbUsername).hasValue(username);
        assertThat(tbPassword).hasValue(password);

    }
}
