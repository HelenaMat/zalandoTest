package tests.automationcamp;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;

import tests.base.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LocatorExamples extends TestBase{
	
	  @Test
	  void goBackAndForce() {
		  
		  String loginUrl = "https://play1.automationcamp.ir/login.html";
		  page.navigate(loginUrl);
		  
		  ///////////////////////
		  ///Locators
		  ///////////////////////
		  
		  //Default locator methods
		  //Locator rememberMeCheckbox = page.getByRole(AriaRole.CHECKBOX);
		  Locator rememberMeCheckbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember me"));
		  //Locator rememberMeCheckbox = page.getByLabel("Remember me");

		  Locator usernameInput = page.getByPlaceholder("Username");
		  Locator passwordInput = page.getByPlaceholder("Password");
		  Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
		  Locator addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
		  
		  //CSS locators
		  Locator dropdown = page.locator("#select_flavor");
		  Locator largeSizeRadio = page.locator("#rad_medium");
		  Locator barbequeSauceRadio = page.locator("#rad_barbeque");
		  Locator onionTopping = page.locator("#onions");
		  Locator quantityInput = page.locator("#quantity");
		  
		  //Text options
		  GetByTextOptions textOptions = new Page.GetByTextOptions().setExact(true);
		  Locator header = page.getByText("     Already    a user? Please login.      ", textOptions);
		  assertThat(header).isVisible();

		  ///////////////////////
		  /// Interactions
		  ///////////////////////
		  
		  //Enter login and password (text input)
		  usernameInput.fill("admin");
		  passwordInput.fill("admin");
		  
		  //Check and uncheck Remember me (checkbox)
		  rememberMeCheckbox.check();
		  rememberMeCheckbox.uncheck();
		  
		  //Click on login (button)
		  loginButton.click();
		  
		  //Select pizza flavor (dropdown)
		  dropdown.selectOption("Supreme");
		  
		  //Choose pizza size and toppings (radio buttons and checkboxes)
		  largeSizeRadio.check();
		  barbequeSauceRadio.check();
		  onionTopping.check();
		  
		  //Add number of pizzas you want to add to cart (text input)
		  quantityInput.type("1");
		  
		  //Press add to cart (button)
		  addToCartButton.click();
	  }
}
