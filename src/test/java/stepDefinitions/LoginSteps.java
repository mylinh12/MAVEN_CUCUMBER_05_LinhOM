package stepDefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;

public class LoginSteps {

	WebDriver driver;
	static String userID, password, loginPageUrl;

	public LoginSteps() {
		driver = Hooks.openBrowser();
	}
	
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl() {
		loginPageUrl = driver.getCurrentUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}
	
	@When("^I click to Login button$")
	public void iClickToLoginButton() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^Verify Home page displayed with message \"(.*?)\"$")
	public void verifyHomePageDisplayed(String messageName) {
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"" + messageName + "\"]")).isDisplayed());
	}

	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
		driver.get(loginPageUrl);
	}

	@When("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email) {
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email + randomEmail());
	}

	@When("^I click to Submit button at Register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I get UserID infor$")
	public void iGetUserIDInfor() {
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		System.out.println("userID = " + userID);
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor() {
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.println("Password = " + password);
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	}

	@When("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^Verify Home page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String arg1) {

	}

	@When("^I open New Customer page$")
	public void iOpenNewCustomerPage() {

	}

	@When("^I input to New Customer form with data$")
	public void iInputToNewCustomerFormWithData(DataTable arg1) {

	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage() {

	}

	@Then("^Verify message displayed with data \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithData(String arg1) {

	}

	@Then("^I verify all above information created success$")
	public void iVerifyAllAboveInformationCreatedSuccess(DataTable arg1) {

	}

	@When("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage() {

	}

	@When("^I open Edit Customer page$")
	public void iOpenEditCustomerPage() {

	}

	@When("^Input Customer ID to textbox$")
	public void inputCustomerIDToTextbox() {

	}

	@When("^I click to Submit button at Edit Customer page$")
	public void iClickToSubmitButtonAtEditCustomerPage() {

	}

	@When("^I input to Edit Customer form with data$")
	public void iInputToEditCustomerFormWithData(DataTable arg1) {

	}

	@Then("^I verify all above information edited success$")
	public void iVerifyAllAboveInformationEditedSuccess(DataTable arg1) {

	}

	public String randomEmail() {
		Random random = new Random();
		String randomEmail = random.nextInt(99999) + "@mailinator.com";
		return randomEmail;
	}
}
