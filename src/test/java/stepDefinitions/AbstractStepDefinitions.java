package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import interfaces.AbstractPageUI;
import pageObjects.AbstractPageObject;
import pageObjects.PageFactoryManage;

public class AbstractStepDefinitions {
	WebDriver driver;
	private AbstractPageObject abstractPage;
	private AbstractTest abstractTest;
	static String loginPageUrl;

	public AbstractStepDefinitions() {
		driver = Hooks.openBrowser();
		abstractPage = PageFactoryManage.openAbstractPage(driver);
		abstractTest = new  AbstractTest();
	}

	@When("^I input to \"(.*?)\" textbox with data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithDynamicData(String textboxID, String value) {
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}
	
	@When("^I input to \"(.*?)\" textbox with random data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithDynamicRandomData(String textboxID, String value) {
		value = value + " " + abstractTest.randomNumber();
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}
	
	@When("^I input to \"(.*?)\" textbox with \"(.*?)\" data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithRandomData(String textboxID, String statusRandom, String value) {
		if(statusRandom.equals("1")) {
			value = value + " " + abstractTest.randomNumber();
		} else if (statusRandom.equals("2")) {
			
			// autotest1253@gmail.com
			value = value + abstractTest.randomEmail();
		}
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}
	
	@When("^I input to \"(.*?)\" textarea with data \"(.*?)\"$")
	public void iInputToDynamicTextAreaWithDynamicData(String textareaID, String value) {
		abstractPage.inputToDynamicTextArea(textareaID, value);
	}
	
	@When("^I select item in \"(.*?)\" dropdown with data \"(.*?)\"$")
	public void iSelectToDynamicDropdownListWithDynamicData(String dropdownID, String value) {
		abstractPage.selectDynamicDropdownList(dropdownID, value);
	}
	
	@When("^I select \"(.*?)\" radio button$")
	public void iSelectToDynamicRadioButton(String radioButtonID) {
		abstractPage.clickToDynamicRadioButton(radioButtonID);
	}
	
	@When("^I click to \"(.*?)\" button$")
	public void iClickToDynamicButton(String buttonID) {
		abstractPage.clickToDynamicButton(buttonID);
	}
	
	@When("^Verify message \"(.*?)\" displayed success$")
	public void iVerifyDynamicMessageDisplayed(String message) {
		abstractTest.verifyTrue(abstractPage.isDynamicMessageDisplay(message));
	}
	
	@When("^I open \"(.*?)\" page$")
	public void iOpenDynamicPage(String pageName) {
		abstractPage.clickToDynamicPageLink(pageName);
	}
	
	@When("^I sleep with \"(.*?)\" times$")
	public void iSleepDynamicTime(String timeMinute) {
		abstractPage.sleepWithDynamicTime(timeMinute);
	}
	
	@When("^I input (first|second) Account ID$")
	public void iInputToAccountID(String account) {
		if(account.equalsIgnoreCase("first")) {
			System.out.println("this first account: action_A");
		}
		if(account.equalsIgnoreCase("second")) {
			System.out.println("this second account: action_B");
		}
	}
	
	@When("^I (?:transfer|withdraw) to \"(.*?)\" USD$")
	public void iTransferToSomethingUSD(String amount) {
		System.out.println("Don't care 'transfer' or 'withdraw', I just care the amount will be get for same	 action_C");
	}
}
