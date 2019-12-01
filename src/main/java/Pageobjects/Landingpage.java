package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//Button[text()='NO THANKS']");
	
	public Landingpage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement getLogin() throws InterruptedException
	
	{
		
		//Thread.sleep(10000);
		return driver.findElement(signin);
		
	}
	
	public WebElement getnavigation()
	{
		return driver.findElement(NavBar);
		
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	
	public int getPopupsize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	

}
