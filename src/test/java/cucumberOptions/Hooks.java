package cucumberOptions;

import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import cucumber.api.java.Before;

public class Hooks {
	
	// Co chu 'static' de co the chay nhieu Thread (luu giu dc su lien ket data giua TC_A va TC_B)
	private static WebDriver driver;
	private static final Logger log = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		
		// Run bang Maven command lAine
		String browser = System.getProperty("BROWSER");

		if (driver == null) {
			try {
				// Kiem tra browser = null -> gan = chrome
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "firefox";
					}
				}
				switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "hchrome":
					System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1366x768");
					driver = new ChromeDriver(options);
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "hfirefox":
					driver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				}

			} catch (UnreachableBrowserException e) {
				driver = new ChromeDriver();
			} catch (WebDriverException e) {
				driver = new ChromeDriver();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get("http://demo.guru99.com/v4");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log.info("-------------- Started to browser --------------");
		}
		return driver;
	}

	// Neu go '@After' o day, thi moi lan chay xong MOT SENARIO thi se bi close browser, se mat session, mat lien ket cac data giua TC_A va TC_B
	public static void close() {
		try {
			if (driver != null) {
				openBrowser().quit();
				log.info("-------------- Close the browser --------------");
			}

		} catch (UnreachableBrowserException e) {
			System.out.println("Can not close the browser");
		}
	}

	private static class BrowserCleanup implements Runnable {
		@Override
		public void run() {
			close();
		}
	}
}
