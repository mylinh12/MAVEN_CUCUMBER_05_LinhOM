package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class AbstractPageObject extends AbstractPage {
	WebDriver driver;

	// Khoi tao contructor de mapping 'driver' cua tang Test Case vs 'driver' cua tang Page Object thong qua mappingDriver
	public AbstractPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void inputToDynamicTextbox(String textboxID, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxID);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxID, value);
	}

	public void inputToDynamicTextArea(String textAreaID, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textAreaID);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textAreaID, value);
	}

	public void selectDynamicDropdownList(String dropdownID, String item) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWNLIST, dropdownID);
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWNLIST, dropdownID, item);
	}

	public void clickToDynamicRadioButton(String radioButtonID) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
	}

	public void clickToDynamicButton(String buttonID) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonID);
	}

	public boolean isDynamicMessageDisplay(String message) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MESSAGE, message);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MESSAGE, message);
	}

	public void clickToDynamicPageLink(String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
	}
	
	public void sleepWithDynamicTime(String timeMinute) {
		long time = Long.parseLong(timeMinute);
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
