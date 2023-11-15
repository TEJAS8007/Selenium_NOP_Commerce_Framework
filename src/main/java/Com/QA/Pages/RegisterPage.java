package Com.QA.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.QA.Utilities.CommonUtitlity;

public class RegisterPage {

	WebDriver driver;
	
	By Registerlink=By.xpath("//a[@class='ico-register']");
	
	By PageLogo=By.cssSelector("div.page-title");
	
	By Gender=By.id("gender-male");
	
	By FirstName=By.id("FirstName");
	
	By LastName=By.id("LastName");
	
	By Day=By.cssSelector("select[name='DateOfBirthDay']");
	
	By Month=By.cssSelector("select[name='DateOfBirthMonth']");
	
	By Year=By.cssSelector("select[name='DateOfBirthYear']");
	
	By emailBox=By.id("Email");
	
	By Company=By.id("Company");
	
	By password=By.id("Password");
	
	By ConPassword=By.id("ConfirmPassword");
	
	By Register=By.cssSelector("button#register-button");
	
	public static String email;
	public static String pass;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String verify_Register_Page_Title() {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(20));
		wb.until(ExpectedConditions.elementToBeClickable(Registerlink)).click();
		return driver.getTitle();
	}
	
	public String Verify_Register_Page_Url() {
		return driver.getCurrentUrl();
	}
	
	public void Send_Register_1(String fn,String ln) {
		
		driver.findElement(Gender).click();
		
		driver.findElement(FirstName).sendKeys(fn);
		
		driver.findElement(LastName).sendKeys(ln);
		
		Select sel1=new Select(driver.findElement(Day));
		sel1.selectByIndex(12);
		
		Select sel2=new Select(driver.findElement(Month));
		sel2.selectByIndex(4);
		
		Select sel3=new Select(driver.findElement(Year));
		sel3.selectByIndex(43);
		
		
	}
	
	public void send_Register_Page_2(String com) {
		List<String> listData= CommonUtitlity.GenerateData();
		email=listData.get(0);
		pass=listData.get(1);
		
		driver.findElement(emailBox).sendKeys(email);
		driver.findElement(Company).sendKeys(com);
		driver.findElement(password).sendKeys(pass);
		System.out.println(driver.findElement(password).getAttribute("value"));
		driver.findElement(ConPassword).sendKeys(pass);
		System.out.println(driver.findElement(ConPassword).getAttribute("value"));
		driver.findElement(Register).click();
	}
}
