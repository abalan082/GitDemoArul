package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class base {
	
	public static WebDriver driver;
	
	
	public Properties prop;

		public WebDriver initializeDriver () throws IOException
		
		{
			System.out.println("test");
			prop = new Properties();
			
			System.out.println(System.getProperty("user.dir"));
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			
			
			prop.load(fis);
			
			String browserName = prop.getProperty("browser");
			
			//mvn test -Dbrowser=chrome
			
			//String browserName = System.getProperty("browser");
			
			if(browserName.contains("chrome"))
				
			{
				
				//execute in chrome driver
				
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32up\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
				//ChromeOptions options = new ChromeOptions();
				
				//if(browserName.contains("headless"))
				//{
					
					//options.addArguments("--headless");
				//}
				
				
				//driver = new ChromeDriver(options);
				
			}
			
			else if (browserName.equals("firefox"))
			{
				
				System.setProperty("webdriver.gecko.driver", "c:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				
				driver = new FirefoxDriver();
				//execute in firefox
				
				
			}
			
			else if (browserName.equals("IE"))
			{
				
				System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
				//driver = new InternetExplorerDriver();
				//IEDesiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//IEDesiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.qaclickacademy.com/");
				//IEDesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
				//IEDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//IEDesiredCapabilities.setJavascriptEnabled(true);
				//IEDesiredCapabilities.setCapability("requireWindowFocus", true);
				//IEDesiredCapabilities.setCapability("enablePersistentHover", false);
				//IEDesiredCapabilities.setCapability("requireWindowFocus", true);
				driver = new InternetExplorerDriver();
				
				
				//execute in IE
			}
			
			System.out.println(browserName);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
			
		}

		
		
	
public void getScreenShots(String result) throws IOException
{
	
	System.out.println("method screenshot");

	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	


Files.copy(src, new File("C://test//"+result+"screenshot.png"));
}

}
	


