package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.PageFactoryManage;
import pageObjects.RegisterPageObject;

public class RegisterSteps_Level_1_PageObjectModel {
	WebDriver driver;
	static String userID, password;
	private RegisterPageObject registerPage;
	private AbstractTest abstractTest;

	// Contructor
	public RegisterSteps_Level_1_PageObjectModel() {
		// Get Driver ID
		driver = Hooks.openBrowser();

		// set Driver ID for Register page
		registerPage = PageFactoryManage.openRegisterPage(driver);
		abstractTest = new AbstractTest();

	}

	@When("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email) {
		registerPage.inputToEmailTextbox(email + abstractTest.randomEmail());
	}
	
	@When("^I click to Submit button at Register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		registerPage.clickToSubmitButton();
	}
	
	@Then("^I get UserID infor$")
	public void iGetUserIDInfor() {
		userID = registerPage.getUserIDTextbox();
		System.out.println("userID at Register page = " + userID);
	}
	
	@Then("^I get Password infor$")
	public void iGetPasswordInfor() {
		password = registerPage.getPasswordTextbox();
		System.out.println("Password at Register page = " + password);
	}
	
	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
		registerPage.openLoginPage(LoginSteps_Level_1_PageObjectModel.loginPageUrl);
	}
	
}
