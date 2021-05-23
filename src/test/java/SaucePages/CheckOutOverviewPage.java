package SaucePages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class CheckOutOverviewPage extends PageObject {

	By finish = By.id("finish");
	By thankyou_header = By.className("complete-header");
	By back_button = By.id("back-to-products");

	public boolean verifyProducts(String products[]) {
		boolean status = false;
		for (String product : products) {
			if (getDriver().findElement(By.xpath("//div[text()=" + "'" + product + "'" + "]")).isDisplayed())
				status = true;
		}
		return status;
	}

	public void FinishButton() {
		element(finish).click();
	}

	public void thankYouHeader() {
		element(thankyou_header).isPresent();
	}

	public void backButton() {
		element(back_button).click();
	}
}
