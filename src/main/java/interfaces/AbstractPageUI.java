package interfaces;

public class AbstractPageUI {

	public static final String DYNAMIC_PAGE_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWNLIST = "//select[@name='%s']";
	public static final String DYNAMIC_MESSAGE = "//p[@class='heading3' and text()='%s']";
}