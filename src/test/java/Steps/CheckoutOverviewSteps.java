package Steps;

import SaucePages.CheckOutOverviewPage;
import net.thucydides.core.annotations.Step;

public class CheckoutOverviewSteps {

	private CheckOutOverviewPage checkoutOverview;

	@Step
	public boolean productsInCart(String products[]) {
		return checkoutOverview.verifyProducts(products);
	}

	@Step
	public void clickFinishButton() {
		checkoutOverview.FinishButton();
	}

	@Step
	public void verifySuccessMessage() {
		checkoutOverview.thankYouHeader();
	}

	@Step
	public void clickBackHomeButton() {
		checkoutOverview.backButton();
	}
}
