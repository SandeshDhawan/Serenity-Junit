package Steps;

import SaucePages.ProductsPage;

public class ProductsPageSteps {

	private ProductsPage productsPage;

	public void cartOption() {
		productsPage.cart();
	}

	public void burgerbutton() {
		productsPage.clickOnBurgerButton();
	}

	public void logout() {
		productsPage.logOut();
	}

	public void aboutButton() {
		productsPage.clickAboutButton();
	}

	public void sauceLabLogo() {
		productsPage.sauceLabLogoVisibility();
	}

	public void closeBurgerBox() {
		productsPage.closeBurgerBox();
	}

	public void sortAlphabeticalOrder(String dropdownoption) {
		productsPage.sortProducts(dropdownoption);
	}

	public void sortPrice(String dropdownoption) {
		productsPage.sortProductsPrice(dropdownoption);
	}

	public void selectproducts(String products[]) {
		productsPage.addProductsToCart(products);
	}

	public void clickCartOpton() {
		productsPage.navigateToCart();
	}

	public boolean filterPresent() {
		return productsPage.filterIsPresent();

	}

}
