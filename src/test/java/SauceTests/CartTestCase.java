package SauceTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SaucePages.CartPage;
import Steps.CartPageSteps;
import Steps.LoginPageSteps;
import Steps.ProductsPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class CartTestCase extends BaseTest {

	@Steps
	CartPageSteps cartPageSteps;

	@Steps
	LoginPageSteps loginPageSteps;

	@Steps
	ProductsPageSteps productsPageSteps;

	@Before
	public void openBrowser() {
		loginPageSteps.isOnLoginPage();
		loginPageSteps.loginAsUser();
	}

	@Test
	public void verifyUserIsAbleToSelectProducts() {
		String products[] = { "Sauce Labs Backpack", "Sauce Labs Onesie" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		Assert.assertTrue(cartPageSteps.productsInCart(products));
	}

	@Test
	public void verifyUserIsAbleRemoveProducts() {
		String products[] = { "Sauce Labs Onesie", "Sauce Labs Backpack", "Sauce Labs Bike Light",
				"Sauce Labs Fleece Jacket" };
		String remove_products[] = { "Sauce Labs Fleece Jacket", "Sauce Labs Bike Light" };
		String available_products[] = { "Sauce Labs Onesie", "Sauce Labs Backpack" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		Assert.assertTrue(cartPageSteps.productsInCart(products));
		cartPageSteps.removeproduct(remove_products);
		Assert.assertTrue(cartPageSteps.productsInCart(available_products));
	}

	@Test
	public void verifyUserIsAbleToComeOnShoppingButton() {
		String products[] = { "Sauce Labs Onesie", "Sauce Labs Backpack", "Sauce Labs Bike Light",
				"Sauce Labs Fleece Jacket" };
		productsPageSteps.selectproducts(products);
		productsPageSteps.clickCartOpton();
		cartPageSteps.clickContinueButton();
		Assert.assertTrue(productsPageSteps.filterPresent());
	}

}
