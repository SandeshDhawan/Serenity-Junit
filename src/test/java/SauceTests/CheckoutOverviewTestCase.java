package SauceTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Steps.CartPageSteps;
import Steps.CheckoutOverviewSteps;
import Steps.CheckoutPageSteps;
import Steps.LoginPageSteps;
import Steps.ProductsPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class CheckoutOverviewTestCase extends BaseTest {
	@Steps
	CartPageSteps cartPageSteps;

	@Steps
	LoginPageSteps loginPageSteps;

	@Steps
	ProductsPageSteps productsPageSteps;

	@Steps
	CheckoutPageSteps checkoutPageSteps;

	@Steps
	CheckoutOverviewSteps checkoutOverviewSteps;

	@Before
	public void openBrowser() {
		loginPageSteps.isOnLoginPage();
		loginPageSteps.loginAsUser();
	}

	@Test
	public void verifyUserIsAbleToPlaceOrder() {
		String products[] = { "Sauce Labs Backpack", "Sauce Labs Onesie" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		Assert.assertTrue(cartPageSteps.productsInCart(products));
		cartPageSteps.clickCheckoutButton();
		checkoutPageSteps.FirstName();
		checkoutPageSteps.LastName();
		checkoutPageSteps.zipCode();
		checkoutPageSteps.clickContinueButton();
		Assert.assertTrue(checkoutOverviewSteps.productsInCart(products));
		checkoutOverviewSteps.clickFinishButton();
		checkoutOverviewSteps.verifySuccessMessage();
		checkoutOverviewSteps.clickBackHomeButton();
		productsPageSteps.filterPresent();
	}
}
