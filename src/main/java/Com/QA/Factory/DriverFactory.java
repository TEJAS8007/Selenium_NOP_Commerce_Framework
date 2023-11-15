package Com.QA.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

	static WebDriver driver;
	static Properties pro;
	
	
	public static WebDriver init_Browser() {
		pro= DriverFactory.Init_Properties();
		
		String browserName= pro.getProperty("browser").toLowerCase().trim();
		
		if(browserName.equals("chrome")) {
			ChromeOptions chrome=new ChromeOptions();
			chrome.setBinary("C:\\Users\\HP\\OneDrive\\Desktop\\Testing Reqmnt\\chrome-win32\\chrome-win32\\chrome.exe");
			driver=new ChromeDriver(chrome);
			
		}
		else if(browserName.equals("firefox")) {
		    driver=new FirefoxDriver();
		    driver.get(pro.getProperty("url"));
		}
		else {
			System.out.println("Please Enter Browser Name correctly...");
		}
		
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}
	
	public static Properties Init_Properties() {
	
		try {
			FileInputStream file=new FileInputStream("src/main/resources/Config/Config.properties");
			pro=new Properties();
			pro.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
}
