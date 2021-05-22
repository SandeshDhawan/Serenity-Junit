package Steps;

import SaucePages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginPageSteps {
	
	private LoginPage loginPage;
	
	@Step
	public void isOnLoginPage(){
		loginPage.open();
	}
	
	@Step
	public void loginAsUser(){
		loginPage.doLogin();
		
	}
	
	@Step
	public void isonProductsPage(){
		loginPage.productsPageVisible();
	}
	@Step
	public void verifyLoginButton(){
		loginPage.loginButton();
	}
}
