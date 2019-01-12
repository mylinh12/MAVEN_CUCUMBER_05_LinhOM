package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactory {

	@FindBy (how = How.XPATH, using="//input[@name='uid']")
	@CacheLookup
	private WebElement userIDTextbox;
	
	@FindBy (how = How.XPATH, using ="//input[@name='password']")
	@CacheLookup
	private WebElement passwordTextbox;
	
	@FindBy (how = How.XPATH, using ="//input[@name='btnLogin']")
	@CacheLookup
	private WebElement loginButton;
	
	@FindBy (how = How.XPATH, using ="//a[text()='here']")
	@CacheLookup
	private WebElement hereLink;
	
	public void inputUserNameTextbox(String userName) {
		userIDTextbox.sendKeys(userName);
	}
	
	public void inputPasswordTextbox(String password) {
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
