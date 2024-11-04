package qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProductPage {

//*****	
	WebDriver driver;
	
	public OrderProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//webelements
	@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=product/product&path=20&product_id=35']/descendant::img")
	private WebElement productimg;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddtoCartbtn;
	
	@FindBy(xpath="//div[text()='Success: You have added ']")
	private WebElement Successtocartmsg;
	
	@FindBy(linkText="shopping cart")
	private WebElement shoppingcartlink;
	
	@FindBy(linkText="Checkout")
	private WebElement checkoutbtn;

	@FindBy(xpath="//select[@id='input-option224']/option[2]")
	private WebElement SizedropdownforProduct8;
	
	//checkoutpage
			@FindBy(xpath="//*[@id='collapse-checkout-option']/div/div/div[1]/div[2]/label/input")
			private WebElement Guestradiobtn;
			
			
			@FindBy(xpath="//input[@id='button-account']")
			private WebElement ContinuebtnOncheckout;
			
			@FindBy(xpath="//input[@id='input-payment-firstname']")
			private WebElement fnamechk;
			
			@FindBy(xpath="//input[@id='input-payment-lastname']")
			private WebElement Lnamechk;
			
			@FindBy(xpath="//input[@id='input-payment-email']")
			private WebElement Emailchk;
			
			@FindBy(xpath="//input[@id='input-payment-telephone']")
			private WebElement Phnchk;
			
			@FindBy(xpath="//input[@id='input-payment-company']")
			private WebElement Companychk;
			
			@FindBy(xpath="//input[@id='input-payment-address-1']")
			private WebElement Address1chk;
			
			@FindBy(xpath="//input[@id='input-payment-address-2']")
			private WebElement Address2chk;
			
			@FindBy(xpath="//input[@id='input-payment-city']")
			private WebElement Citychk;
			
			@FindBy(xpath="//input[@id='input-payment-postcode']")
			private WebElement PostalCodechk;
			
			@FindBy(xpath="//select[@id='input-payment-country']/option[@value='99']")
			private WebElement Countrychk;
			
			@FindBy(xpath="//select[@id='input-payment-zone']/option[@value='1475']")
			private WebElement Statechk;
			
			@FindBy(xpath="//input[@id='button-guest']")
			private WebElement ClickContinue;
			
			//payment
			@FindBy(xpath="//input[@name='agree']")
			private WebElement ClickOnagreebtn;
			
			@FindBy(xpath="//input[@id='button-payment-method']")
			private WebElement ClickOnContinuepaymentbtn;
			
			@FindBy(xpath="//div[contains(text(), 'Warning: No Payment options are available. Please ')]")
			private WebElement Paymentwarningtext;
			
			@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=information/contact']")
			private WebElement ContactUsUrl;
	//**********************action methods****************************************
	public WebElement ClickOnProduct()
	{
		productimg.click();
		return AddtoCartbtn;
	}
	
	public void ClickOnAddToCartbtn()
	{
		AddtoCartbtn.click();
	}
	public String retrieveSuccessToCartWarning()
	{
		String Shoppingcartmsg = Successtocartmsg.getText();
		return Shoppingcartmsg;
	}
	public void ClickOnShoppingCart()
	{
		shoppingcartlink.click();
	}
	public WebElement ClickOnCheckout()
	{
		checkoutbtn.click();
		return checkoutbtn;
	}
	public void ClickOndropdownproduct8()
	{
		SizedropdownforProduct8.click();	
	}
	//checkout
	
	public void ClickOnrGuestradiobtn()
	{
		Guestradiobtn.click();
	}
	public void ClickOnContinuebtnOncheckout()
	{
		ContinuebtnOncheckout.click();
	}
	
	
	
	//------------------------------------------------------------------------
	
	public void InputFirstName(String fname)
	{
		fnamechk.sendKeys(fname);
	}
	public void InputLastName(String lname)
	{
		Lnamechk.sendKeys(lname);
	}
	public void InputEmail(String Email)
	{
		Emailchk.sendKeys(Email);
	}
	public void InputTelephone(String phonechk)
	{
		Phnchk.sendKeys(phonechk);
	}
	public void InputCompany(String Company)
	{
		Companychk.sendKeys(Company);
	}
	public void InputAddress1(String Address1)
	{
		Address1chk.sendKeys(Address1);
	}
	public void InputAddress2(String Address2)
	{
		Address2chk.sendKeys(Address2);
	}
	
	public void InputCity(String city)
	{
		Citychk.sendKeys(city);
	}
	public void InputPostalCode(String postalcode)
	{
		PostalCodechk.sendKeys(postalcode);
	}
	public void InputCountry()
	{
		Countrychk.click();
	}
	public void InputState()
	{
		Statechk.click();
	}
	public void ClickOncontinuechk()
	{
		ClickContinue.click();
	}
	
	//------------Payment---------------
	
	public void ClickOnAgree()
	{
		ClickOnagreebtn.click();
	}
	public void ClickOnContinuePayment()
	{
		ClickOnContinuepaymentbtn.click();
	}
	public String RetrievePaymentWarningMesg()
	{
		String WarningpayText=Paymentwarningtext.getText();
		return WarningpayText;
	}
	public void ClickOnContactUs()
	{
		ContactUsUrl.click();
	}	
	
}
