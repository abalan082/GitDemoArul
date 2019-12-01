package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[id='user_password']");
	private By submit = By.cssSelector("[type='submit']");
	
	
	public Loginpage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement getemail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement getsubmit()
	{
		return driver.findElement(submit);
		
	}
	

}
