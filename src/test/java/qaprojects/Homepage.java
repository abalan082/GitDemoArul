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
import resources.base;
 


public class Homepage extends base{
	
	private static Logger log = LogManager.getLogger(Homepage.class.getName());
	
@Test(dataProvider="getdata")
	public void basepageNavigation(String username, String pass) throws IOException, InterruptedException
	{
	driver = initializeDriver();
	log.info("Driver initialized successfully");
	
	//Thread.sleep(10000);
	
	driver.get(prop.getProperty("url"));
		
		//driver.get("http://www.google.com/");
		
		Landingpage lanep = new Landingpage(driver);
		
		
		lanep.getLogin().click();
		driver.manage().window().maximize();
		
		Loginpage lp = new Loginpage(driver);
		
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(pass);
		lp.getsubmit().click();
		
		driver.close();
		
	}
		@DataProvider
		
		public Object[][] getdata()
		{
			Object data[][] = new Object[2][2];
			
			data[0][0] = "user1@gmail.com";
			data[0][1] = "pass1234";
			
			data[1][0] = "user2@gmail.com";
			data[1][1] = "pass1235";
					
			return data;
			
			
		}
		
		
				
				@AfterTest
				
				public void teardown()
				{
					
					
					log.info("browser closed");
					
				}


		
		
		
	}


