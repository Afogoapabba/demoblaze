
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;



import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class test_navigation extends TestBase {
    //Navigate to a URL
    @Test
    void navigateToPage() {

        assertEquals("https://www.demoblaze.com/", page.url());
    }
    @Test
    void navigateToHome() {
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
        navigationLink.click();
        assertEquals("https://www.demoblaze.com/index.html", page.url());
    }
    @Test
    void navigateToContact() {
        Locator locator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact"));
        locator.click();
    }
    @Test
    void navigateToAboutUs() {
        Locator locator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About us"));
        locator.click();
    }
    @Test
    void navigateToCart() {
        Locator navigationLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
        navigationLink.click();
        assertEquals("https://www.demoblaze.com/cart.html", page.url());
    }
    @Test
    void navigateToLogin() {
        Locator locator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in"));
        locator.click();
    }
    @Test
    void navigateToSignUp() {
        Locator locator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign up"));
        locator.click();
    }
//    void navigateToPage() {
//        page.navigate("https://www.demoblaze.com/");
//        page.locator("input[name=\"search\"]").click();
//        page.locator("input[name=\"search\"]").fill("playwright");
//        page.locator("input[name=\"search\"]").press("Enter");
//        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
}


