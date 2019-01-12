package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManage;

public class HomePageStep_Level_1_PageObjectModel {
	
	// default/ public/ protected/ private
	WebDriver driver;
	private AbstractTest abstractTest;
	private HomePageObject homePageObject;

	public HomePageStep_Level_1_PageObjectModel() {
		// Get Driver ID
		driver = Hooks.openBrowser();

		// set Driver ID for Register page
		homePageObject = PageFactoryManage.openHomePage(driver);
		abstractTest = new AbstractTest();

	}

	@Then("^Verify Home page displayed with message \"(.*?)\"$")
	public void verifyHomePageDisplayedWithMessage(String messageName) {
		abstractTest.verifyTrue(homePageObject.isHomePageDisplay(messageName));
	}
}
