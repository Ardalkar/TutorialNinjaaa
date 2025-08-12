package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import qa.PageObject.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class amzonpractice {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{	
	
		 System.setProperty("WebDriver.chromedriver","C:\\workspace\\java-workspacecreate\\TutorialNinjaProj\\browser\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test
	public void countsuggestion()
	{
//		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
//		searchbox.sendKeys("mobile");
//		
//		List<WebElement> l = driver.findElements(By.xpath("//div[@role='row']"));
//		int size=l.size();
//		System.out.println(size);
//		
//		for(int i=1;i<=l.size();i++)
//		{
//			if(i==6) {
//				l.get(i).click();
//			}
//			
//		}
		
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
	    searchbox.sendKeys("mobile");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-suggestion-container']")));

	    List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
	    System.out.println("Number of suggestions: " + suggestions.size());

	    for (int i = 0; i < suggestions.size(); i++) {
	        System.out.println(suggestions.get(i).getText());
	        if (i == 5) {
	            suggestions.get(i).click();
	            break;
	        }
	    }
		
		
	}
	@Test (enabled=true)
	public void windowHandle()
	{
		/* Logic 
		 
		 1.parentwindow
		 2.childwindow
		 3.link to open child window
		 
		  set<string> w = driver.getWindowHandles()
		  for(String it:w)
		  {
		  	driver.switchTo(w);
		  }
		 
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String parentwindow = driver.getWindowHandle();
		String childwindow = driver.getWindowHandle();
		WebElement childlink =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-copyright-wrapper']//a")));
		childlink.click();
		
//		System.out.println("parent "+parentwindow);
//		System.out.println("child "+childWebElement);
		
		Set<String> windows = driver.getWindowHandles();
			
			for(String w:windows)
			{
				driver.switchTo().window(w);
			}
		
			driver.switchTo().defaultContent();
	}
	
	
	@Test(enabled=false)
	public void performamazon()
	{
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 WebElement languageDropdown = driver.findElement(By.id("icp-nav-flyout"));
		 actions.moveToElement(languageDropdown).perform();

		 WebElement selectHindi =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-icp']//a[@lang='hi-IN']")));
		 actions.moveToElement(selectHindi).click().perform();
 
		 WebElement hindiText = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		 Assert.assertTrue(hindiText.isDisplayed(), "Language not changed to Hindi");
		
	}
	

	@AfterTest
	public void closebrowser()
	{
		//driver.close();
	}
	
	
}
