package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	private static Logger log = LogManager.getLogger(Base.class.getName());

	/*Invoke the corresponding browser, based on the name provided by the user.*/
	public WebDriver intialiseDriver() throws IOException {
		 //Create one global environment “Properties” file so there I will simply pass browser “chrome”.
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/Love/Project/src/main/java/Resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			//execute in chrome browser
			System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}else {
			//execute in safari
			driver = new SafariDriver();
		}
		
		//Provide implicit wait to all the test cases steps execution for 10 seconds that will run after the browser is invoked.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshot(String testName) throws IOException {          
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//"OutputType.FILE" = You captured the screen in the form a graphic that can be stored in a file format
		//"File src =" = Get the captured file format capture in a File object virtually
		//Now copy the content of src object (virtually captured screen) in a local file (real screenshot) so that the human can see it.
		FileUtils.copyFile(src, new File("/Users/Love/Project/ScreenShots/"+testName+"screenshot.png"));
		log.info(testName+" Screenshot success!");
	}
}
