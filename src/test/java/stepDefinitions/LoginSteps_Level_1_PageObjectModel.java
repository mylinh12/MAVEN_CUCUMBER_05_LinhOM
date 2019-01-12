package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManage;

public class LoginSteps_Level_1_PageObjectModel {
	WebDriver driver;
	private LoginPageObject loginPage;
	static String loginPageUrl;

	public LoginSteps_Level_1_PageObjectModel() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManage.openLoginPage(driver);
	}
	
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl() {
		loginPageUrl = loginPage.getLoginPageUrl();
	}
	
	@When("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickHereLink();
	}
	
	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox() {
		System.out.println("userID at Login page = " + RegisterSteps_Level_1_PageObjectModel.userID);
		loginPage.inputUserNameTextbox(RegisterSteps_Level_1_PageObjectModel.userID);
	}

	@When("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		System.out.println("Password at Login page = " + RegisterSteps_Level_1_PageObjectModel.password);
		loginPage.inputPasswordTextbox(RegisterSteps_Level_1_PageObjectModel.password);
	}

	@When("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		loginPage.clickLoginButton();
	}
	
}
