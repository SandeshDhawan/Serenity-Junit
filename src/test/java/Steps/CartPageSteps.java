package Steps;

import SaucePages.CartPage;
import SaucePages.ProductsPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.findby.By;

public class CartPageSteps {

	private CartPage cartpage;

	public boolean productsInCart(String products[]) {
		return cartpage.verifyProducts(products);
	}

	public void removeproduct(String products[]) {
		cartpage.removeProducts(products);
	}
	
	public void clickContinueButton(){
		cartpage.continueShoppingButton();
	}

}
