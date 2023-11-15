package Com.QA.Tests;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.QA.Base.BaseTest;
import Com.QA.Factory.DriverFactory;
import Com.QA.Pages.AddToCartPage;
import Com.QA.Pages.AddressPage;
import Com.QA.Pages.HomePage;
import Com.QA.Pages.LoginPage;
import Com.QA.Pages.PaymentPage;
import Com.QA.Pages.RegisterPage;
import Com.QA.Pages.ShoppingCartPage;
import Com.QA.Utilities.CommonUtitlity;

public class PagesTest extends BaseTest{

	
	@Test(priority = 1)
	public void Home_Page_Title_Test() {
		String title= home.Verify_HomePage_Title();
		System.out.println("Home Page Title : "+title);
		
		log.info("Verifying Home Page Title...");
		if(title.equals("nopCommerce demo store")) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Title success...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page Title failed...");
		}
	}

	@Test(priority = 2)
	public void Home_Page_Url_Test() {
		String url= home.Verify_Home_Page_Url();
		System.out.println("Home Page url : "+url);
		
		log.info("Verifying Home Page Url...");
		if(url.equals("https://demo.nopcommerce.com/")) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page url successs...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page url failed...");
		}
	}

	@Test(priority = 3)
	public void Home_Page_Header_Links_Test() {
		int link= home.Verify_Home_Page_Header_Links();
		System.out.println("Home Page Header links : "+link);
		
		log.info("Verifying Home Page Header links...");
		
		if(link==32) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Header links Success...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page Header links failed...");
		}
	}

	@Test(priority = 4)
	public void Home_Page_footer_Links_Test() {
		int link= home.Verify_Home_Page_Footer_Links();
		System.out.println("Home Page Footer links : "+link);
		
		log.info("Verifying Home Page Footer links...");
		if(link==22) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Footer links Success...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page Footer links Failed...");
		}
	}

	@Test(priority = 5)
	public void Home_Page_Products_Test() {
		int link= home.Verify_Home_page_Products();
		System.out.println("Home Page products : "+link);
		
		log.info("Verifying Home Page Products...");
		
		if(link==4) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page Products Success...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page Products failed...");
		}
	}

	@Test(priority = 6)
	public void Home_Page_Products_Title_Test() {
		home.Verify_Home_page_Products_Title();
		log.info("Verifying Home Page Products Title...");
	}

	@Test(priority = 7)
	public void Home_Page_Logo_Test() {
		boolean logo= home.Verify_Home_Page_Logo();
		System.out.println("Home Page logo : "+logo);
		
		log.info("Verifying Home Page logo...");
		
		if(logo==true) {
			Assert.assertTrue(true);
			log.info("Verifying Home Page logo Success...");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Home Page logo failed...");
		}
	}

	@Test(priority = 8)
	public void Home_Page_Customer_Currency_Test() {
		int logo= home.Verify_CustomerCurrency();
		System.out.println("Home Page customer Currency : "+logo);
		
		log.info("verifying home page Customer Currency");
		
		if(logo==2) {
			Assert.assertTrue(true);
			log.info("verifying home page Customer Currency Sucess...");
		} else {
			Assert.assertTrue(false);
			log.warn("verifying home page Customer Currency Failed....");

		}
	}

	@Test(priority = 9)
	public void Register_Page_Title_Test() {
		String ExpectedTitle= register.verify_Register_Page_Title();
		System.out.println("Register Page Title : "+ExpectedTitle);
		
		log.info("verifying Register page Title");

		if(ExpectedTitle.equals("nopCommerce demo store. Register")) {
			Assert.assertTrue(true);
			log.info("verifying Register page Title sucess...");
		} else {
			Assert.assertTrue(false);
			log.info("verifying Register page Title failed...");
		}
	}

	@Test(priority = 10)
	public void Register_Page_Url_Test() {
		String ExpectedUrl= register.Verify_Register_Page_Url();
		System.out.println("Register Page url : "+ExpectedUrl);
		
		log.info("Verifying Register Page Url....");
		
		if(ExpectedUrl.equals("https://demo.nopcommerce.com/register?returnUrl=%2F")) {
			Assert.assertTrue(true);
			log.info("Verifying Register Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Register Page Url failed....");
		}
	}

	@Test(priority = 11)
	public void Register_Page_Register1_Test() {
		register.Send_Register_1(DataProp.getProperty("fn"),
				DataProp.getProperty("ln"));
		log.info("Verifying Register Page Registration....");
	}

	@Test(priority = 12)
	public void Register_Page_Register2_Test() {
		register.send_Register_Page_2(DataProp.getProperty("com"));
		log.info("Verifying Register Page Registration....");
	}

	@Test(priority = 13)
	public void Click_on_Login_Test() {
		login.Click_on_Login_Button();
		log.info("Verifying Register Page Registration....");
	}

	@Test(priority = 14)
	public void Verify_LoginPage_title_Test() {
		String ExpectedTitle= login.Verify_Login_Page_Title();
		System.out.println("Login Page Title : "+ExpectedTitle);
		
		log.info("Verifying Login Page Title....");
		
		if(ExpectedTitle.equals("nopCommerce demo store. Login")) {
			Assert.assertTrue(true);
			log.info("Verifying Login Page Title Success....");
		} else {
			Assert.assertTrue(false);
			log.info("Verifying Login Page Title Failed....");
		}
	}

	@Test(priority = 15)
	public void Verify_LoginPage_Url_Test() {
		String ExpectedUrl= login.Verify_Login_Page_Url();
		System.out.println("Login Page Url : "+ExpectedUrl);
		
		log.info("Verifying Login Page Url....");
		
		if(ExpectedUrl.equals("https://demo.nopcommerce.com/login?returnUrl=%2F")) {
			Assert.assertTrue(true);
			log.info("Verifying Login Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Login Page Url Failed....");
		}
	}

	@Test(priority = 16)
	public void Verify_LoginPage_Texts_Test() {
		boolean found= login.Verify_Login_Page_Text();
		System.out.println("Login Page Texts : "+found);
		
		log.info("Verifying Login Page Texts....");
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Login Page Texts Success....");
		} else {
			Assert.assertTrue(false);
			log.info("Verifying Login Page Texts Failed....");
		}
	}

	@Test(priority = 17)
	public void Verify_LoginPage_Info_Test() {
		boolean found= login.Verify_Login_Page_Info();
		System.out.println("Login Page info : "+found);
		
		log.info("Verifying Login Page Info....");
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Login Page Info Success....");
		} else {
			Assert.assertTrue(false);
			log.info("Verifying Login Page Info Failed....");
		}
	}

	@Test(priority = 18)
	public void Verify_LoginPage_Login_Action_Test() {
		login.Perform_Login_Action();
		log.info("Verifying Login Page Action....");
	}

	@Test(priority = 19)
	public void Verify_Add_TO_Cart_Title() {
		add.click_On_Product();
		String Expectedtitle= add.Verify_Add_Cart_Page_Title();
		System.out.println("Add to cart title : "+Expectedtitle);
		
		log.info("Verifying AddToCart Page Title....");
		
		if(Expectedtitle.equals("nopCommerce demo store. Apple MacBook Pro 13-inch")) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Title Success....");
		} else {
			Assert.assertTrue(false);
			log.info("Verifying AddToCart Page Title Failed....");
		}
	}

	@Test(priority = 20)
	public void Verify_Add_TO_Cart_Url() {
		String Expectedtitle= add.Verify_Add_Cart_Page_Url();
		System.out.println("Add to cart url : "+Expectedtitle);
		
		log.info("Verifying AddToCart Page Url....");
		
		if(Expectedtitle.equals("https://demo.nopcommerce.com/apple-macbook-pro-13-inch")) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page Url Failed....");
		}
	}

	@Test(priority = 21)
	public void Verify_Add_TO_Cart_Product_Name() {
		String productName= add.Add_Cart_Product_Name();
		System.out.println("Add to cart ProductName : "+productName);
		
		log.info("Verifying AddToCart Page ProductName....");
		
		if(productName.equals("Apple MacBook Pro 13-inch")) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page ProductName Sucess....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page ProductName Failed....");
		}
	}

	@Test(priority = 22)
	public void Verify_Add_TO_Cart_Product_Desciption() {
		String Expectedtitle= add.Add_Cart_Product_Description();
		System.out.println("-----------------Product Desciption------------------------");
		System.out.println(Expectedtitle);
		System.out.println("-----------------Product Desciption------------------------");
		
		log.info("Verifying AddToCart Page Product Description....");

		if(Expectedtitle.equals("A groundbreaking Retina display. A new force-sensing trackpad. All-flash architecture. Powerful dual-core and quad-core Intel processors. Together, these features take the notebook to a new level of performance. And they will do the same for you in everything you create."))
		{
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Product Description suceess....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page Product Description Failed....");
		}
	}

	@Test(priority = 23)
	public void Verify_Add_TO_Cart_Product_Price() {
		boolean found= add.Add_Cart_Product_Price();
		System.out.println("Add to cart Price : "+found);
		
		log.info("Verifying AddToCart Page Product Price....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Product Price Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page Product Price Failed....");
		}
	}

	@Test(priority = 24)
	public void Verify_Add_TO_Cart_Product_Full_Descirpition() {
		boolean found= add.Add_Cart_Product_Full_descitpiton();
		System.out.println("-----------------Product Desciption------------------------");
		System.out.println(found);
		System.out.println("-----------------Product Desciption------------------------");

		log.info("Verifying AddToCart Page Product Full Description....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Product Full Description Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page Product Full Description Failed....");
		}
	}

	@Test(priority = 25)
	public void Verify_Add_TO_Cart_Product_Specification() {
		boolean found= add.Add_Cart_Product_Specification();
		System.out.println("-----------------Product Specification------------------------");
		System.out.println(found);
		System.out.println("-----------------Product Desciption------------------------");
		add.click_On_CArt_Button();
		
		log.info("Verifying AddToCart Page Product Specification....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying AddToCart Page Product Specification Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying AddToCart Page Product Specification Failed....");
		}
	}

	@Test(priority = 26)
	public void Verify_shoppingCart_Title_Test() {
		String ExpectedTitle=shopping.Verify_Shopping_Cart_Title();
		System.out.println("ShoppingCart title : "+ExpectedTitle);
		
		log.info("Verifying ShoppingCart Page Title....");
		
		if(ExpectedTitle.equals("nopCommerce demo store. Shopping Cart")) {
			Assert.assertTrue(true);
			log.info("Verifying ShoppingCart Page Title Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying ShoppingCart Page Title failed....");
		}
	}

	@Test(priority = 27)
	public void Verify_shoppingCart_Url_Test() {
		String ExpectedUrl=shopping.Verify_Shopping_Cart_url();
		System.out.println("ShoppingCart url : "+ExpectedUrl);
		
		log.info("Verifying ShoppingCart Page Url....");
		
		if(ExpectedUrl.equals("https://demo.nopcommerce.com/cart")) {
			Assert.assertTrue(true);
			log.info("Verifying ShoppingCart Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying ShoppingCart Page Url failed....");
		}
	}

	@Test(priority = 26)
	public void Verify_shoppingCart_Product_In_Cart_Test() {
		boolean found=shopping.Verify_Shopping_Cart_product_InCart();
		System.out.println("Product in Cart : "+found);
		
		log.info("Verifying ShoppingCart Page Product in Cart....");
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying ShoppingCart Page Product in Cart Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying ShoppingCart Page Product in Cart Failed....");
		}
	}

	@Test(priority = 27)
	public void Verify_shoppingCart_Product_Name_Test() {
		String found=shopping.Verify_shoping_cart_Product_Name();
		System.out.println("Product Name : "+found);
		
		log.info("Verifying ShoppingCart Page Product Name....");
		
		if(found.equals("Apple MacBook Pro 13-inch")) {
			Assert.assertTrue(true);
			log.info("Verifying ShoppingCart Page Product Name Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying ShoppingCart Page Product Name Failed....");
		}
	}

	@Test(priority = 28)
	public void Verify_shoppingCart_Gift_Test() {
		shopping.Verify_shopping_Cart_Gift_Wrapping();
		log.info("Verifying ShoppingCart Page Product Gift Wrapping....");
	}

	@Test(priority = 29)
	public void Verify_shoppingCart_Toatl_Test() {
		shopping.Verify_shopping_Cart_Total_table();
		log.info("Verifying ShoppingCart Page Product Total table....");
	}

	@Test(priority = 30)
	public void Verify_shoppingCart_Checout_Test() {
		shopping.Click_on_Checkout();
		log.info("Verifying ShoppingCart Page Click on Checkout....");
	}

	@Test(priority = 31)
	public void Verify_Address_Page_Title_Test() {
		String ExpectedTitle= address.Verify_Address_page_Title();
		System.out.println("Address Page Title : "+ExpectedTitle);
		
		log.info("Verifying Address Page title....");
		
		if(ExpectedTitle.equals("nopCommerce demo store. Checkout")) {
			Assert.assertTrue(true);
			log.info("Verifying Address Page title Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Address Page title failed....");
		}
	}

	@Test(priority = 32)
	public void Verify_Address_Page_Url_Test() {
		String ExpectedUrl= address.Verify_Address_Page_url();
		System.out.println("Address Page Url : "+ExpectedUrl);
		
		log.info("Verifying Address Page Url....");
		
		if(ExpectedUrl.equals("https://demo.nopcommerce.com/onepagecheckout#opc-billing")) {
			Assert.assertTrue(true);
			log.info("Verifying Address Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Address Page Url Failed....");
		}
	}

	@Test(priority = 32)
	public void Verify_Address_Page_logo_Test() {
		boolean found= address.Verify_Address_Page_Logo();
		System.out.println("Address Page Logo : "+found);
		
		log.info("Verifying Address Page Logo....");
		
		if(found==true) {
			Assert.assertTrue(true);
			log.info("Verifying Address Page Logo Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Address Page Logo Failed....");
		}
	}

	@Test(priority = 33,dataProvider = "getData")
	public void Verify_Address_Page_Data_Test(String ci,String ad1,String ad2,String zp,String ph,String fx) {
		address.Send_Address_Data(ci, ad1, ad2, zp, ph, fx);
		log.info("Verifying Address Page Sending Data....");
	}

	@DataProvider(name="getData")
	public Object[][] getData() {
		Object[][] obj=CommonUtitlity.get_Excel_Data();
		return obj;
	}

	@Test(priority = 34)
	public void Payment_Page_Title_Test() {
		String ExpectedTitle= payment.Verify_Payment_Page_Title();
		System.out.println("Payement title : "+ExpectedTitle);
		
		log.info("Verifying Payment Page Title....");
		
		if(ExpectedTitle.equals("nopCommerce demo store. Checkout")) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Title Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Payment Page Title Failed....");
		}
	}
	
	@Test(priority = 35)
	public void Payment_Page_Url_Test() {
		String ExpectedUrl= payment.Verify_Payment_Page_Url();
		System.out.println("Payement url : "+ExpectedUrl);
		
		log.info("Verifying Payment Page Url....");
		
		if(ExpectedUrl.equals("https://demo.nopcommerce.com/onepagecheckout#opc-billing")) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Url Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Payment Page Url Failed....");
		}
	}
	
	@Test(priority = 36)
	public void Payment_Page_Shiping_Methods_Test() {
		List<WebElement> shippingList=payment.Verify_Payment_Page_shipping_Methods();
		
		for(WebElement ele :shippingList) {
			String text= ele.getText();
			System.out.println(text);
		}
		log.info("Verifying Payment Shipping Methods....");
	}
	
	@Test(priority = 37)
	public void Payment_Page_Shiping_Methods_Continue_Test() {
		payment.Click_On_Shipping_Continue();
		log.info("Verifying Payment Page Click on shipping Continue....");
	}
	
	@Test(priority = 38)
	public void Payment_Page_Payments_Methods_Test() {
		List<WebElement> shippingList=payment.Verify_Payement_Page_Payments_Methods();
		
		for(WebElement ele :shippingList) {
			String text= ele.getText();
			System.out.println(text);
		}
		log.info("Verifying Payment Page Payment Methods....");
	}
	
	@Test(priority = 39)
	public void Payment_Page_Payments_Methods_Continue_Test() {
		payment.Click_on_Payment_Continue();
		log.info("Verifying Payment Page payment Continue....");
	}
	
	@Test(priority = 40)
	public void Payment_Page_Payments_Information_Test() {
		int paycount=payment.Verify_Payment_Page_Payment_information();
		System.out.println(paycount);
		
		log.info("Verifying Payment Page Payment Information....");
		
		if(paycount==4) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Payment Information Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Payment Page Payment Information Failed....");
		}
	}
	
	@Test(priority = 41)
	public void Payment_Page_Billing_Address_Test() {
		int paycount=payment.Verify_Payment_Page_Billing_Address();
		System.out.println(paycount);
		
		log.info("Verifying Payment Page Billing Address....");
		
		if(paycount==9) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Billing Address Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Payment Page Billing Address failed....");
		}
	}
	
	@Test(priority = 42)
	public void Payment_Page_Shipping_Address_Test() {
		int paycount=payment.Verify_Payment_Page_Shipping_Address();
		System.out.println(paycount);
		
		log.info("Verifying Payment Page Shipping Address....");
		
		if(paycount==9) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Shipping Address Success....");
		} else {
			Assert.assertTrue(false);
			log.warn("Verifying Payment Page Shipping Address Failed....");
		}
	}
	
	@Test(priority = 43)
	public void Payment_Page_Final_Table_Test() {
		payment.Verify_PayMent_Page_Final_Table();
		log.info("Verifying Payment Page Final Table....");
	}
	
	@Test(priority = 44)
	public void Payment_Page_Order_Numberr_Test() {
		String orderno= payment.Verify_Order_Number();
		System.out.println("Order Number : "+orderno);
		
		log.info("Verifying Payment Page Order Number....");
		
		if(orderno.equals(payment.Returning_Order_Number())) {
			Assert.assertTrue(true);
			log.info("Verifying Payment Page Order Number Matched....");
		} else {
			Assert.assertTrue(false);
			log.info("Verifying Payment Page Order Number Failed....");
		}
	}
	
	
}
