package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.Base.BaseClass;
import qa.PageObject.HomePage;
import qa.PageObject.OrderProductPage;
import qa.utils.Utilities;
//new to import
public class OrderProduct extends BaseClass {
	
	public WebDriver driver;
	OrderProductPage orderproductpage;
	// public Properties TestDataprop = new Properties();
	public OrderProduct()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenAppUrl(prop.getProperty("browsernm"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1,invocationCount = 1,dataProvider="UserdetailsSupplier")
	public void VerifyOrderProduct(String firstName, String lastName,String email, String phone, String Company,
            String address1,  String address2, String City, String postalCode ) throws Exception 
	{
		 
		 HomePage homepage = new HomePage(driver);
		 
		 homepage.mouseOverOnDesktop();
	     homepage.clickOnShowAllDesktop(); 
	     
		 OrderProductPage orderproductpage = new OrderProductPage(driver);
		 
		 WebElement element = orderproductpage.ClickOnProduct();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView()", element);
		 
		 //choose available option from dropdown
		 orderproductpage.ClickOndropdownproduct8();
		 
		 Thread.sleep(500); 
		 orderproductpage.ClickOnAddToCartbtn();
		
		 Thread.sleep(500); 
		 //click on shopping cart
		 orderproductpage.ClickOnShoppingCart();
				 
		 Thread.sleep(3500); 
		 WebElement element1 = orderproductpage.ClickOnCheckout();
		 JavascriptExecutor js1 = (JavascriptExecutor)driver;
		 js1.executeScript("arguments[0].scrollIntoView()", element1);
		 Thread.sleep(1500);
		 orderproductpage.ClickOnrGuestradiobtn();
		 orderproductpage.ClickOnContinuebtnOncheckout();
	
		 //from where to take name,last name all the test data to fill in form 	 
		 
		 orderproductpage.InputFirstName(firstName);
		 orderproductpage.InputLastName(lastName);
		 orderproductpage.InputEmail(email);
		 orderproductpage.InputTelephone(phone);
		 orderproductpage.InputCompany(Company);
		 orderproductpage.InputAddress1(address1);
		 orderproductpage.InputAddress2(address2);
		 orderproductpage.InputCity(City);
		 orderproductpage.InputPostalCode(postalCode);
		 orderproductpage.InputCountry();
		 orderproductpage.InputState();
		 orderproductpage.ClickOncontinuechk();
		 
	//	 WebDriverWait wait = new WebDriverWait(driver, 20);
	//	 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
		 
		 String actualpaymentWarningmsg = orderproductpage.RetrievePaymentWarningMesg();
		 String expectedpaymentwarningmsg = TestDataprop.getProperty("PaymentOptionsNotAvailable");
		 
		 if (actualpaymentWarningmsg.equals(expectedpaymentwarningmsg)) {
			    orderproductpage.ClickOnContactUs();
			} else {
			    Assert.assertNotEquals(actualpaymentWarningmsg, expectedpaymentwarningmsg, 
			                           "Expected Payment warning message is displayed");
			}
		 
		 //payment
		// orderproductpage.ClickOnAgree();
		// orderproductpage.ClickOnContinuePayment();
	}
	
	@DataProvider (name="UserdetailsSupplier")
		public Object[][] supplyUserTestData()
		{
			Object [][] Userdata = Utilities.GetDataFromExcel("UserDetails"); //UserDetails is name of excel(below excel)
			return new Object[][]{Userdata[2]};
		
		}
	
		

	 
	
	
	
	
	
}
