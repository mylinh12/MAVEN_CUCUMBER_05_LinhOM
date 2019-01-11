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
	public void verifyHomePageDisplayedWithMessage(String messageName) {
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
		System.out.println("userID at Register page = " + userID);
	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor() {
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.println("Password at Register page = " + password);
	}

	@Given("^I input to Username textbox$")
	public void iInputToUsernameTextbox() {
		System.out.println("userID at Login page = " + userID);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	}

	@When("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		System.out.println("Password at Login page = " + password);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	public String randomEmail() {
		Random random = new Random();
		String randomEmail = random.nextInt(99999) + "@mailinator.com";
		return randomEmail;
	}
}
