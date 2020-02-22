package seleniumgrid;

public class Desiredcapabilities 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Parameters("Browser")

@Test
public void NewTours_LogInTest(String browser) 
{

System.out.println("The name of the Browser is : "+browser);


//DesiredCapabilities-it is used to specify which Browser and platform should be considered
// for the distributed Testing

// info realted to NODE

DesiredCapabilities cap = null;

if(browser.equalsIgnoreCase("chrome"))
{
cap= DesiredCapabilities.chrome();
cap.setBrowserName("chrome");
cap.setPlatform(Platform.WINDOWS);
}
else
if(browser.equalsIgnoreCase("firefox"))
{
cap = DesiredCapabilities.firefox();
cap.setBrowserName("firefox");
cap.setPlatform(Platform.WINDOWS);
}

// connecting to the Remote Hub Server - to move to the nodes to perform the task

RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.6.1:4444/wd/hub"),cap);

String url="http://newtours.demoaut.com";

driver.get(url);

FileInputStream file = new FileInputStream(".//src//com//ApplicationTestDataFiles//NewTours_LogInTestData.xlsx");
XSSFWorkbook workBook = new XSSFWorkbook(file);
XSSFSheet sheet = workBook.getSheet("Sheet1");

int rowCount=sheet.getLastRowNum();

for(int i=1;i<=rowCount;i++)
{
// goes to an active Row
Row row=sheet.getRow(i);

// <input type="text" name="userName" size="10">
WebElement userName=driver.findElement(By.name("userName"));
userName.clear();
userName.sendKeys(row.getCell(0).getStringCellValue());

 // <input type="password" name="password" size="10">
WebElement password=driver.findElement(By.name("password"));
password.clear();
password.sendKeys(row.getCell(1).getStringCellValue());

// <input type="image" name="login" value="Login" src="/images/btn_signin.gif?osCsid=62569422c1b0d0a5be6140908ed45426" width="58" height="17" alt="Sign-In" border="0">
WebElement signIn=driver.findElement(By.name("login"));
signIn.click();


String expected_HomePageTitle="Find";
System.out.println("The expected Title of the New Tours Home Page is:"
+expected_HomePageTitle);

String actual_WebPageTitle=driver.getTitle();
System.out.println(" The actual title of the NewTours WebPage is :"+actual_WebPageTitle );

if(actual_WebPageTitle.contains(expected_HomePageTitle))
{
System.out.println(" LogIN Successfull - PASS");
row.createCell(2).setCellValue("LogIN Successfull - PASS");
}
else
{
System.out.println(" LogIn Failed - FAIL");
row.createCell(2).setCellValue("LogIn Failed - FAIL");
}

driver.navigate().back();

FileOutputStream file1 = new FileOutputStream("./src/com/ApplicationTestResultFiles/NewTours_LogIn_TestResult.xlsx");
workBook.write(file1);

}

}






