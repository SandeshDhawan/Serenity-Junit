package Steps;

import SaucePages.CheckoutPage;
import net.thucydides.core.annotations.Step;

public class CheckoutPageSteps {

	private CheckoutPage checkoutPage;

	@Step
	public void FirstName() {
		checkoutPage.enterFirstName();
	}

	@Step
	public void LastName() {
		checkoutPage.enterLastName();
	}

	@Step
	public void zipCode() {
		checkoutPage.enterZipCode();
	}

	@Step
	public void clickCancelButton() {
		checkoutPage.cancelButton();
	}

	@Step
	public void errorMessagePresent() {
		checkoutPage.errormessage();
	}

	@Step
	public void clickContinueButton() {
		checkoutPage.continue_button();
	}

}
