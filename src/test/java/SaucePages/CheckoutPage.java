package SaucePages;

import java.util.Random;

import org.openqa.selenium.By;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import net.serenitybdd.core.pages.PageObject;

public class CheckoutPage extends PageObject {

	By FirstName = By.id("first-name");
	By LastName = By.id("last-name");
	By Zipcode = By.id("postal-code");
	By cancel_button = By.id("cancel");
	By error = By.xpath("//div[@class='error-message-container error']");
	By continue_button = By.id("continue");

	Faker faker = new Faker();

	public void enterFirstName() {
		element(FirstName).type(faker.name().firstName());
	}

	public void enterLastName() {
		element(LastName).type(faker.name().lastName());
	}

	public void enterZipCode() {
		element(Zipcode).type(faker.address().zipCode());
	}

	public void cancelButton() {
		element(cancel_button).click();
	}

	public void errormessage() {
		element(error).isPresent();
	}

	public void continue_button() {
		element(continue_button).click();
	}
}
