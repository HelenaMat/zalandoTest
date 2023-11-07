package tests.automationcamp;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import tests.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	void loginAsAdmin() {
		//Setup
		
		//Navigation
		String loginUrl = "https://play1.automationcamp.ir/login.html";
		page.navigate(loginUrl);
		
		//Locate elements
		Locator usernameInput = page.getByPlaceholder("Username");
		Locator passwordInput = page.getByPlaceholder("Password");
		Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
		Locator header = page.getByText("Dinesh's Pizza House");

		//Interact with elements
		usernameInput.fill("admin");
		passwordInput.fill("admin");
		loginButton.click();
		
		//Assert result
		assertThat(header).isVisible();
		
		//Cleanup
	}
}
