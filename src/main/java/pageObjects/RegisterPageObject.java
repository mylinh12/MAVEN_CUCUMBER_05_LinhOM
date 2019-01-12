package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void inputToEmailTextbox(String emailAdress) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdress);
	}
	
	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	
	public String getUserIDTextbox() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXTBOX);
	}
	
	public String getPasswordTextbox() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	}
	
	public LoginPageObject openLoginPage(String loginPageURL) {
		openAnyUrl(driver, loginPageURL);
		return PageFactoryManage.openLoginPage(driver);
	}
}
