package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	private Actions actions;

//Objects
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@class='dropdown-toggle'][@href='https://tutorialsninja.com/demo/index.php?route=product/category&path=20']")
	private WebElement desktop;
	
	@FindBy(xpath="//a[@class='see-all'][@href='https://tutorialsninja.com/demo/index.php?route=product/category&path=20']")
	private WebElement ShowAlldesktop;
	
	//constructor is created to remove locator's hardcoding from Login.java
	//control came here after declare
	public HomePage(WebDriver driver) //driver from Login is passed here & that driver is assigned to the HomePage Class
	{
		this.driver=driver;
		//PageFactory provides below line to overcome stale element reference exception
		PageFactory.initElements(driver, this); //you can write this like PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
//Actions
	
	public void ClickOnMyAccount()
	{
		MyAccountDropMenu.click();
	}
	
	public LoginPage SelectLoginOption()
	{
		LoginDropMenu.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage ClickOnRegister()
	{
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBoxFeild(String productText)
	{
		searchBoxField.sendKeys(productText);
	}
	public SearchPage ClickOnSearchButton()
	{
		searchButton.click();
		return new SearchPage(driver);
	}
	public void ClickOnShowAllDesktop()
	{
		ShowAlldesktop.click();
	}
    // Mouseover action on desktop element
    public void mouseOverOnDesktop() {
        actions.moveToElement(desktop).perform();
    }
    // Click action on ShowAllDesktop element
    public void clickOnShowAllDesktop() {
        ShowAlldesktop.click();
    }
	
}
