package qaprojects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Landingpage;
import Pageobjects.Loginpage;

import junit.framework.Assert;
import resources.base;



public class validationNavigation extends base{
	
	private static Logger log = LogManager.getLogger(validationNavigation.class.getName());
	
@Test
	public void basepageNavigation() throws IOException
	{
		
		
		//driver.get("http://www.google.com/");
		
		Landingpage lanep = new Landingpage(driver);
		
		Assert.assertTrue(lanep.getnavigation().isDisplayed());
		log.info("Navigation Display verified successfully");
			
	}

@BeforeTest

public void initialize() throws IOException
{
	driver = initializeDriver();
	log.info("Driver initialized successfully");
	
	driver.get(prop.getProperty("url"));
	log.info("Navigation to Homepage");
}
		
		@AfterTest
		
		public void teardown()
		{
			driver.close();
			
			log.info("browser closed");
			
		}

		
		
		
	}


