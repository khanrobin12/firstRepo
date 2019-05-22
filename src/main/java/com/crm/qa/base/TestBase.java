package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	protected TestBase(){
		 prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\AliNoor\\eclipse-workspace\\FREE_CRM_PRO_\\src\\main\\java\\com\\crm\\qa\\configaration\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\AliNoor\\eclipse-workspace\\FREECRM\\chromedriver.exe"); 
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\AliNoor\\eclipse-workspace\\FREECRM\\geckodriver.exe"); 
			driver = new FirefoxDriver();
			 
		}else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\AliNoor\\eclipse-workspace\\FREECRM\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else {
			System.out.println("There is no Browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver =e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/index.html");
		
		
		
		
	}

}
