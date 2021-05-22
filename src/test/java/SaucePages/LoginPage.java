package SaucePages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

public class LoginPage extends PageObject {

	By username = By.id("user-name");
	By password = By.id("password");
	By login_button = By.id("login-button");
	By products_title = By.className("title");

	public void doLogin() {
		getDriver().manage().window().maximize();
		element(username).type("standard_user");
		element(password).type("secret_sauce");
		element(login_button).click();
	}

	public void productsPageVisible() {
		isElementVisible(products_title);
	}
	
	public void loginButton(){
		isElementVisible(login_button);
	}

}
