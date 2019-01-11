package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class BankHomePageObject extends AbstractPage {

	WebDriver driver;
	
	public BankHomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isHomePageDisplay() {
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE);
	}
	
	public boolean isUserUndisplayed(String userID) {
		return isControlUndisplayed(driver, HomePageUI.USER_ID_TEXT, userID);
	}
	
}
