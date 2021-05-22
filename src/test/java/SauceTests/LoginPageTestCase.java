package SauceTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Steps.LoginPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginPageTestCase extends BaseTest {

	@Steps
	LoginPageSteps loginPageSteps;

	@Test
	public void verifyLogin() {
		loginPageSteps.isOnLoginPage();
		loginPageSteps.loginAsUser();
		loginPageSteps.isonProductsPage();
	}

}
