package SauceTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Steps.CartPageSteps;
import Steps.CheckoutPageSteps;
import Steps.LoginPageSteps;
import Steps.ProductsPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class CheckOutTestCase extends BaseTest {

	@Steps
	LoginPageSteps loginPageSteps;

	@Steps
	CartPageSteps cartPageSteps;

	@Steps
	CheckoutPageSteps checkoutPageSteps;

	@Steps
	ProductsPageSteps productsPageSteps;

	@Before
	public void openBrowser() {
		loginPageSteps.isOnLoginPage();
		loginPageSteps.loginAsUser();
	}

	@Test
	public void verifyUserIsAbletoClickOnCancelButton() {
		String products[] = { "Sauce Labs Onesie", "Sauce Labs Backpack", "Sauce Labs Bike Light",
				"Sauce Labs Fleece Jacket" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		cartPageSteps.clickCheckoutButton();
		checkoutPageSteps.clickCancelButton();
		cartPageSteps.removeButtonIsPresent();
	}

	@Test
	public void verifyErrorMessage() {
		String products[] = { "Sauce Labs Onesie", "Sauce Labs Backpack", "Sauce Labs Bike Light",
				"Sauce Labs Fleece Jacket" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		cartPageSteps.clickCheckoutButton();
		checkoutPageSteps.clickContinueButton();
		checkoutPageSteps.errorMessagePresent();
	}
}
