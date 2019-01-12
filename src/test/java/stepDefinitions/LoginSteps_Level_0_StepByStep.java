package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;

public class LoginSteps_Level_0_StepByStep {

	WebDriver driver;
	static String userID, password, loginPageUrl;

	public LoginSteps_Level_0_StepByStep() {
		driver = Hooks.openBrowser();
	}
	
	@When("^I click to Login button$")
	public void iClickToLoginButton() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Given("^I open New Customer page$")
	public void iOpenNewCustomerPage() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	}

	@When("^I input to New Customer form with data$")
	public void iInputToNewCustomerFormWithData(DataTable customerTable) {
	    List<Map<String, String>> customer = customerTable.asMaps(String.class, String.class);
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));;
	    driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));;
	    driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));;
	    driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));;
	    driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));;
	    driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));;
	    driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));;
	    driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email"));;
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));;
	    
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	/* HEADER ->      | Name      | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password |
	index 0-> ROW 1 ->| Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 |
	index 1-> ROW 2 ->| Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 |
	index 2-> ROW 3 ->| Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 |
	*/
	    
	}

	@When("^I sleep some times$")
	public void iSleepSomeTimes() throws InterruptedException {
	    Thread .sleep(10000);
	}
	
	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage() {
	    
	    
	}

	@Then("^Verify message displayed with data \"(.*?)\"$")
	public void verifyMessageDisplayedWithData(String arg1) {
	    
	    
	}

	@Then("^I verify all above information created success$")
	public void iVerifyAllAboveInformationCreatedSuccess(DataTable arg1) {
	    
	}

	@When("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage() {
	    
	}
	
	public String randomEmail() {
		Random random = new Random();
		String randomEmail = random.nextInt(99999) + "@mailinator.com";
		return randomEmail;
	}
}