package SauceTests;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;

public class BaseTest {
	
	@Managed(uniqueSession=true)
	WebDriver driver;

}
