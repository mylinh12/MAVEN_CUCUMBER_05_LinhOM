package actions;

import org.openqa.selenium.WebDriver;

public class BankPageFactoryManage {
	
	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	
	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static BankHomePageObject openHomePage(WebDriver driver) {
		return new BankHomePageObject(driver);
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
	
}
