package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoitOrangeHRM2 {

	public static void main(String[] args) {
		String url="https://opensource-demo.orangehrmlive.com/";
		WebDriver driver = null;
		
				//DOMConfigurator.configure(System.getProperty("user.dir")+"\\log4j.xml");
		
		//Logger logger = Logger.getLogger(OrangeHRM.class);
		
		
		//PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sudhe\\OneDrive\\Desktop\\SudheerSelenium\\practice1\\driverfiles1\\chromedriver.exe");
		 driver = new ChromeDriver();

		 System.out.println(" googlechrome Browser Launched Successfully ");

		

		// Browser Maximize
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to(url);

		System.out.println(" Successfully Launched OrangeHR Application ");
		
		
		}

		@Test(priority=1)
		public void logInTest()
		{
			//<input name="txtUsername" id="txtUsername" type="text">
		WebElement userName= driver.findElement(By.name("txtUsername"));
		//userName.clear();
		userName.sendKeys("Admin");

		System.out.println(" Sucessfully Updated UserName ");
		
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		WebElement password=driver.findElement(By.name("txtPassword"));
		//password.clear();
		password.sendKeys("admin123");

		System.out.println(" Successfully Updated Password");
		//Log.info("Successfully Updated Password");

		WebElement logInButton=driver.findElement(By.id("btnLogin"));
		logInButton.click();
		System.out.println(" Successfully performed Click on LogIn Button ");
		//Log.info("Successfully performed Click on LogIn Button");

		String expected_HomePageUserNameText="Admin";
		System.out.println(" The Text of the UserName is : "+expected_HomePageUserNameText);
		//Log.info(" The Text of the UserName is : "+expected_HomePageUserNameText);

		// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		WebElement homePageUserText_Element=driver.findElement(By.id("welcome"));
		String actual_homePageUserText=homePageUserText_Element.getText();
		//Log.info("The actual text is : "+actual_homePageUserText);

		if(actual_homePageUserText.contains(expected_HomePageUserNameText))
		{
		System.out.println(" LogIN Successfull- PASS");
		//Log.info("LogIN Successfull- PASS");
		}
		else
		{
		System.out.println(" LogIN FAIL - FAIL");
		//Log.info("LogIN FAIL - FAIL");
		}

		}


		@Test(priority=2)
		public void pim()
		{
		WebElement pim=driver.findElement(By.id("menu_pim_viewPimModule"));

		Actions act = new Actions(driver);
		act.moveToElement(pim).perform();

		System.out.println(" Successfully Navigated to PIM ");
		//logger.info("Successfully Navigated to PIM ");

		}

		@Test(priority=3)
		public void addEmployee()
		{
		WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
		addEmployee.click();

		System.out.println(" Successfully perfromed click on AddEmployee ");
		//logger.info("Successfully perfromed click on AddEmployee ");
		}

		@Test(priority=4)
		public void registratingNewEmployee() throws InterruptedException, Exception 
		{
		WebElement firstName=driver.findElement(By.id("firstName"));
		firstName.clear();
		firstName.sendKeys("Srini");

		System.out.println(" Successfully entered FirstName ");
		//logger.info("Successfully entered FirstName");

		WebElement middleName=driver.findElement(By.id("middleName"));
		middleName.clear();
		middleName.sendKeys("Hello");

		System.out.println(" Successfully entered MiddleName");
		//logger.info("Successfully entered MiddleName");

		WebElement lastName=driver.findElement(By.id("lastName"));
		lastName.clear();
		lastName.sendKeys("Testing");

		System.out.println(" Successfully entered LastNamr");
		//Log.info("Successfully entered LastName");

		WebElement employeeId=driver.findElement(By.id("employeeId"));
		String addEmployeeWebPageEmployeeid=employeeId.getAttribute("value");
		System.out.println(" The Employee id is : "+addEmployeeWebPageEmployeeid);
		//logger.info("The Employee id is : "+addEmployeeWebPageEmployeeid);

		WebElement chooseFile=driver.findElement(By.id("photofile"));
		chooseFile.click();

		System.out.println(" Successfully performed Click on ChooseFile button ");
		//logger.info("Successfully performed Click on ChooseFile button ");

		Thread.sleep(10000);

		java.lang.Runtime.getRuntime().exec("C:\\Users\\sudhe\\OneDrive\\Desktop\\Application(.exe)");

		System.out.println(" Successfully selected and uploaded the Profile Image ");
		//logger.info("Successfully selected and uploaded the Profile Image ");
		Thread.sleep(10000);

		WebElement saveButton=driver.findElement(By.id("btnSave"));
		saveButton.click();

		System.out.println(" Successfully performed click on Save Button ");
		//logger.info("Successfully performed click on Save Button ");

		}

		//@AfterTest
		//public void tearDown()
		//{
		driver.quit();
		//logger.info("OrangeHRM Application closed successfully ");
		//}
	
	}




	}

}
