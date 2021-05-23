package SaucePages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;

public class ProductsPage extends PageObject {

	By cart = By.xpath("//a[@class='shopping_cart_link']");
	By burger_button = By.xpath("//div[@class='bm-burger-button']");
	By logout = By.id("logout_sidebar_link");
	By about_button = By.id("about_sidebar_link");
	By sauce_lab_logo = By.xpath("//div[@class='nav-image']");
	By close_burger_box = By.id("react-burger-cross-btn");
	By Sorting_button = By.className("product_sort_container");
	By All_Products_List = By.xpath("//div[@class='inventory_item_name']");
	By Products_Price = By.xpath("//div[@class='inventory_item_price']");

	public void cart() {
		shouldBeVisible(cart);
	}

	public void clickOnBurgerButton() {
		element(burger_button).click();
	}

	public void logOut() {
		element(logout).waitUntilPresent().click();
	}

	public void clickAboutButton() {
		element(about_button).click();
	}

	public void sauceLabLogoVisibility() {
		element(sauce_lab_logo).waitUntilVisible().shouldBeVisible();
	}

	public void closeBurgerBox() {
		element(close_burger_box).click();
		element(burger_button).shouldBeVisible();
	}

	public void sortProducts(String dropdownoption) {
		ArrayList<String> ActualProductsList = new ArrayList<>();
		ArrayList<String> ExpectedProductsList = new ArrayList<>();
		List<WebElement> BeforeApplyingFilter;
		List<WebElement> AfterApplyingFilter;

		BeforeApplyingFilter = getDriver().findElements(All_Products_List);
		for (WebElement product : BeforeApplyingFilter)
			ExpectedProductsList.add(product.getText());

		element(Sorting_button).click();
		selectFromDropdown(getDriver().findElement(Sorting_button), dropdownoption);

		AfterApplyingFilter = getDriver().findElements(All_Products_List);

		for (WebElement product : AfterApplyingFilter)
			ActualProductsList.add(product.getText());

		if (dropdownoption.equals("Name (Z to A)"))
			Collections.sort(ExpectedProductsList, Collections.reverseOrder());

		Assert.assertEquals("Products Are Not Sorted properly", ExpectedProductsList, ActualProductsList);

	}

	public void sortProductsPrice(String dropdownoption) {
		ArrayList<String> ActualProductsPrice = new ArrayList<>();
		ArrayList<String> ExpectedProductsPrice = new ArrayList<>();
		List<WebElement> BeforeApplyingFilter;
		List<WebElement> AfterApplyingFilter;

		BeforeApplyingFilter = getDriver().findElements(Products_Price);
		for (WebElement productprice : BeforeApplyingFilter)
			ExpectedProductsPrice.add(productprice.getText().replace("$", ""));

		element(Sorting_button).click();
		selectFromDropdown(getDriver().findElement(Sorting_button), dropdownoption);

		AfterApplyingFilter = getDriver().findElements(Products_Price);

		for (WebElement productprice : AfterApplyingFilter)
			ActualProductsPrice.add(productprice.getText().replace("$", ""));

		Float expectedprice[] = new Float[ExpectedProductsPrice.size()];
		Float actualprice[] = new Float[ActualProductsPrice.size()];

		for (int i = 0; i < ActualProductsPrice.size(); i++)
			actualprice[i] = Float.parseFloat(ActualProductsPrice.get(i));

		for (int i = 0; i < ExpectedProductsPrice.size(); i++)
			expectedprice[i] = Float.parseFloat(ExpectedProductsPrice.get(i));

		if (dropdownoption.equals("Price (low to high)"))
			Arrays.sort(expectedprice);
		else
			Arrays.sort(expectedprice, Collections.reverseOrder());

		for (int i = 0; i < actualprice.length; i++)
			Assert.assertEquals("Products are not sorted according to price", actualprice[i], expectedprice[i]);

	}

	public void addProductsToCart(String products[]) {

		for (String product : products)
			getDriver()
					.findElement(By.xpath("//div[text()=" + "'" + product + "'"
							+ "]//parent::div//parent::a//parent::div//parent::div//div[@class='pricebar']//button"))
					.click();

	}

	public void navigateToCart() {
		element(cart).click();
	}
	
	public boolean filterIsPresent(){
		return element(Sorting_button).isPresent();
	}
}
