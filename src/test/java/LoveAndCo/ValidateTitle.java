package LoveAndCo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import resources.Base;

public class ValidateTitle extends Base{
	
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = intialiseDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void HomePageTitleValidation() throws IOException {
		
		HomePageObjects hp = new HomePageObjects(driver);
		//hp.fCText().getText(); //if you want to print the text present in the object. But using this the script will never fail.
		//So let's verify if the text is "Featured Courses" or not.
		//compare the text from the browser with our requirement value (here "Featured Courses")
		//For this, user Assert class 
		AssertJUnit.assertEquals(hp.fCText().getText(), "FEATURED COURSES");
		AssertJUnit.assertTrue(hp.navigationBar().isDisplayed());
		log.info("Successfully Validated Text Message");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null; 
	}
}
