package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;
	
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isHomePageDisplay(String message) {
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE, message);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE, message);
	}
	
	public boolean isUserUndisplayed(String userID) {
		return isControlUndisplayed(driver, HomePageUI.USER_ID_TEXT, userID);
	}
	
}
