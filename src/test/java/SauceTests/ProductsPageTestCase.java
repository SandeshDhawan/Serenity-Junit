package SauceTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import Steps.LoginPageSteps;
import Steps.ProductsPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ProductsPageTestCase extends BaseTest {

	@Steps
	ProductsPageSteps productsPageSteps;

	@Steps
	LoginPageSteps loginPageSteps;

	@Before
	public void openBrowser() {
		loginPageSteps.isOnLoginPage();
		loginPageSteps.loginAsUser();
	}

	@Test()
	public void verifyCartOption() {
		productsPageSteps.cartOption();
	}

	@Test()
	public void verifyUserIsAbleToLogout() {
		productsPageSteps.burgerbutton();
		productsPageSteps.logout();
		loginPageSteps.verifyLoginButton();
	}

	@Test
	public void verifyUserIsAbleToNavigateToAboutPage() {
		productsPageSteps.burgerbutton();
		productsPageSteps.aboutButton();
		productsPageSteps.sauceLabLogo();

	}

	@Test
	public void VerifyUserIsAbleToCloseBurgerBox() {
		productsPageSteps.burgerbutton();
		productsPageSteps.closeBurgerBox();
	}

	@Test
	public void VerifyUserIsAbleToSortFromZtoA() {
		productsPageSteps.sortAlphabeticalOrder("Name (Z to A)");
	}

	@Test
	public void VerifyUserIsAbleToSortFromAtoZ() {
		productsPageSteps.sortAlphabeticalOrder("Name (A to Z)");
	}

	@Test
	public void verifyUserIsAbleToSortProductFromLowtoHighPrice() {
		productsPageSteps.sortPrice("Price (low to high)");
	}
	
	@Test
	public void verifyUserIsAbleToSortProductFromHightoLowPrice() {
		productsPageSteps.sortPrice("Price (high to low)");
	}
}
