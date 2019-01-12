package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManage {
	
	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	
	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static WithdrawPageObject openWithdrawPage(WebDriver driver) {
		return new WithdrawPageObject(driver);
	}
	
	public static EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
	public static AbstractPageObject openAbstractPage(WebDriver driver) {
		return new AbstractPageObject(driver);
	}
}
