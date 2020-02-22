package pageobjectmodel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pomexample {
 
WebDriver driver= null ;	
	
String url="http://www.newtours.demoaut.com/";
	
	
@Test
public void setUp()
{


System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhe\\OneDrive\\Desktop\\SudheerSelenium\\practice1\\driverfiles1\\chromedriver.exe");
driver = new ChromeDriver();

 Pomconnectors rgpage=new Pomconnectors(driver);
 
 driver.get(url);
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  rgpage.clickregister();
 rgpage.setfirstname("sudheer");
 rgpage.setlastname("kakarapalli");
 rgpage.setphone("9849945725");
 rgpage.setusername("sudheerkaug1994@gmail.com");
 rgpage.setaddress("madhavapatnam");
 rgpage.setcityname("kakinada");
rgpage.setstatename("andhrapradesh");
rgpage.setpostalcode("533005");




	
}	
}
