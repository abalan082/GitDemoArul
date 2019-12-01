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



public class validation extends base{
	
	private static Logger log = LogManager.getLogger(validation.class.getName());
	
@Test
	public void basepageNavigation() throws IOException
	{
		
		//driver.get("http://www.google.com/");
		
		Landingpage lanep = new Landingpage(driver);
		
		
		Assert.assertEquals("FEATURED COURSES123", lanep.getTitle().getText());
		
	}
@BeforeTest

public void initialize() throws IOException
{
	driver = initializeDriver();
	
	log.info("Driver initialized successfully");
	
	
	driver.get(prop.getProperty("url"));
	
}
		
		/*@AfterTest
		
		public void teardown()
		{
			driver.close();
			
		
		} */

		

		
		
		
	}


