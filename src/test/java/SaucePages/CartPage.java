package SaucePages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

	By continue_button = By.xpath("//button[@class='btn btn_secondary back btn_medium']");
	By checkout_button = By.id("checkout");
	By remove_button = By.id("remove-sauce-labs-backpack");

	public boolean verifyProducts(String products[]) {
		boolean status = false;
		for (String product : products) {
			if (getDriver().findElement(By.xpath("//div[text()=" + "'" + product + "'" + "]")).isDisplayed())
				status = true;
		}
		return status;
	}

	public void removeProducts(String products[]) {
		for (String product : products) {
			getDriver().findElement(By.xpath("//div[text()=" + "'" + product + "'"
					+ "]//parent::a//parent::div//parent::div//button[text()='Remove']")).click();
		}

	}

	public void continueShoppingButton() {
		element(continue_button).click();
	}

	public void checkoutButton() {
		element(checkout_button).click();
	}

	public void removeButtonVisibility() {
		element(remove_button).isPresent();
	}
}
