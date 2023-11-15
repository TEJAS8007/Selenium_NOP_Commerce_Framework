package Com.QA.Base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Com.QA.Factory.DriverFactory;
import Com.QA.Pages.AddToCartPage;
import Com.QA.Pages.AddressPage;
import Com.QA.Pages.HomePage;
import Com.QA.Pages.LoginPage;
import Com.QA.Pages.PaymentPage;
import Com.QA.Pages.RegisterPage;
import Com.QA.Pages.ShoppingCartPage;
import Com.QA.Utilities.CommonUtitlity;

public class BaseTest {

	protected static WebDriver driver;
	protected static HomePage home;
	protected static LoginPage login;
	protected static Properties pro;
	protected static AddToCartPage add;
	protected static RegisterPage register;
	protected static Properties DataProp;
	protected static ShoppingCartPage shopping;
	protected static AddressPage address;
	protected static PaymentPage payment;
	protected static Logger log;


	@SuppressWarnings("deprecation")
	@BeforeTest
	public void set_UP() {
		driver= DriverFactory.init_Browser();
		pro=DriverFactory.Init_Properties();
		DataProp= CommonUtitlity.init_DataProp();
		home=new HomePage(driver);
		login=new LoginPage(driver);
		add=new AddToCartPage(driver);
		register=new RegisterPage(driver);
		shopping=new ShoppingCartPage(driver);
		address=new AddressPage(driver);
		payment=new PaymentPage(driver);
		log=LogManager.getLogger(this.getClass());
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Before Test Executed....");
	}
	
	@AfterTest
	public void tear_down() {
		driver.quit();
		log.info("After Test Executed........");
	}
}
