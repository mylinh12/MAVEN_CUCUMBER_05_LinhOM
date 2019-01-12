package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	/*ACTIONs:
	 * - get Login page url
	 * - input username
	 * - input password
	 * - click Submit button
	 * - click 'here' link*/
	
	WebDriver driver;
	
	// Khoi tao contructor de mapping 'driver' cua tang Test Case vs 'driver' cua tang Page Object thong qua mappingDriver
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	// ACTIONs:
	public void openLoginPage(String loginPageURL) {
		openAnyUrl(driver, loginPageURL);
	}
	
	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}
	
	public void inputUserNameTextbox(String userName) {
		waitForControlVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userName);
	}
	
	public void inputPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public HomePageObject clickLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManage.openHomePage(driver);
	}
	
	public RegisterPageObject clickHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManage.openRegisterPage(driver);
	}
	
}
