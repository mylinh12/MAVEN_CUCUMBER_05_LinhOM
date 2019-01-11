package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	WebDriver driver;

	// Khoi tao log
	protected final Log log;

	// Vi moi file TCs deu ke thu AbstractTest, nen contructor cua AbstractTest la noi de bat dau viec ghi log.
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browserName, String urlName) {
		if (browserName.equals("chrome")) {

			// Cach 1 - tro toi file chromedriver: System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
			// Cach 2 - dung WebDriverManage de chuong trinh tu tai ve.
			WebDriverManager.chromedriver().setup();
			
			// Setting Options for Chrome
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");
			options.addArguments("start-maximized"); // tuong duong cau: driver.manager().windows().maximized();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			driver = new ChromeDriver(capabilities);
			
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("chromeheadless")) {
			// Setting cho viec chay headless
			// System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefoxheadless")) {
			// System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			// khoi tao firefox driver cua options
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			// WebDriverManager.iedriver().setup();
			 WebDriverManager.iedriver().architecture(io.github.bonigarcia.wdm.Architecture.X32).setup();
			
			// Setting Options for IE
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("ignoreZoomSettings", true);
			capabilities.setCapability("requiredWindowFocus", true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			
			driver = new InternetExplorerDriver(capabilities);
			
		} else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(urlName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	protected void closeBrowser(WebDriver driver) {
		try {
			// delete all cookies
			driver.manage().deleteAllCookies();
			
			// Detect OS (Windows/ Linux/ MAC)
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				// Kill process
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			// log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			log.info("=== Throw error message: " + e.getMessage() + " ===\n");

			// Se add ket qua error vao TestNG report cho minh.
			VertificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);

			// Con cai nay la dung de add status (true/false) to ReportNG report cho minh.
			// Khi ko co dong nay, thi tat ca cac loai reports se bao Pass het (la bi sai nha), khi co dong nay vao thi report bao chinh xac hon (co fail xuat hien)
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSEDd===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			log.info("=== Throw error message: " + e.getMessage() + " ===\n");
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFail(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			log.info("=== Throw error message: " + e.getMessage() + " ===\n");
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
