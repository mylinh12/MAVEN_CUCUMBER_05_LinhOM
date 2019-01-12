package commons;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.AbstractPageUI;
import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManage;
import pageObjects.WithdrawPageObject;

public class AbstractPage {

	private long longTimeout = 30;
	private long shortTimeout = 10;

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String idTextboxValue, String value) {
		locator = String.format(locator, idTextboxValue);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	// Ham nay danh cho tag name <select> - <option>
	public void selectItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String idDropdown, String item) {
		locator = String.format(locator, idDropdown);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	// Ham nay danh cho Agular, JQuery, ...
	public void selectCustomDropdownList(WebDriver driver, String dropdown, String listItems, String valueItem) {
		WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
		dropdownElement.click();
		List<WebElement> allItems = driver.findElements(By.xpath(listItems));
		// Wait de tat ca cac phan tu trong dropdown list dc hien thi
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		// dung vong lap For duyet qua tung phan tu
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(valueItem)) {
				// scroll to item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				// check item displays
				item.isDisplayed();
				// neu actual text = expected text thi click vao phan tu do va break khoi vong lap
				item.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	// rest paramester String... values => dung cho Dynamic Locator
	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
	}

	// dau 3 cham ... la truyen nhieu tham so dynamic %s vao 1 chuoi.
	public boolean isControlUndisplayed(WebDriver driver, String locator, String... values) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		locator = String.format(locator, (Object[]) values);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public void pressKeyForElement(WebDriver driver, String locator, Keys keyName) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, keyName);
	}

	public void uploadFile(WebDriver driver, String locator, String fileName) {
		String projectDirectory = System.getProperty("user.dir");
		String filePath = projectDirectory + "\\fileUpload\\" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(filePath);
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		// System.out.println("------ Wait for control visible: " + locator + "------");
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	// rest paramester String... values => dung cho Dynamic Locator, do do, phan truyen values minh truyen bao nhieu bien cung dc
	public void waitForControlVisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	public void waitForControlInvisible(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}

	// rest paramester String... values => dung cho Dynamic Locator, do do, phan truyen values minh truyen bao nhieu bien cung dc
	public void waitForControlInvisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}

	public Object clickToElementByJS(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}

	public Object clickToElementByJS(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}

	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);

		switch (pageName) {
		case "New Customer":
			return PageFactoryManage.openNewCustomerPage(driver);
		case "Edit Customer":
			return PageFactoryManage.openEditCustomerPage(driver);
		case "Withdrawal":
			return PageFactoryManage.openWithdrawPage(driver);
		case "Delete Account":
			return PageFactoryManage.openDeleteAccountPage(driver);
		default:
			return PageFactoryManage.openHomePage(driver);
		}

	}

	/* BANK GURU PAGEs */
	public HomePageObject openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManage.openHomePage(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManage.openNewCustomerPage(driver);
	}

	public WithdrawPageObject openWithdrawPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		return PageFactoryManage.openWithdrawPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManage.openEditCustomerPage(driver);
	}

	public DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		return PageFactoryManage.openDeleteAccountPage(driver);
	}

	public void sleepWithDynamicTimeout(long timeoutSeconds) {
		try {
			Thread.sleep(timeoutSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
