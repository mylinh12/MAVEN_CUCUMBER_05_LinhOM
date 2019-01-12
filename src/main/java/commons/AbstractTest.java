package commons;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {

	WebDriver driver;

	// Khoi tao log
	protected final Log log;

	// Vi moi file TCs deu ke thu AbstractTest, nen contructor cua AbstractTest la noi de bat dau viec ghi log.
	public AbstractTest() {
		log = LogFactory.getLog(getClass());
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
	
	public String randomEmail() {
		Random rand = new Random();
		String email = rand.nextInt(999999) + "@gmail.com";
		return email;
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

	public boolean verifyTrue(boolean condition) {
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

	public boolean verifyFail(boolean condition) {
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

	public boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
