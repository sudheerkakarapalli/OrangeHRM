package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pomconnectors {

	WebDriver driver;
//	<a href="mercuryregister.php">C</a>
	
	By register=By.linkText("REGISTER");
	//<input maxlength="60" name="firstName" size="20">
	
	By firstname=By.name("firstName");
	
	//<input maxlength="60" name="lastName" size="20">
	
	By lastname=By.name("lastName");
		
	//<input maxlength="20" name="phone" size="15">
	
	By phone=By.name("phone");
	
	
	//<input name="userName" id="userName" size="35" maxlength="64">
	
	By username=By.id("userName");
	
	//<input maxlength="60" name="address1" size="40">
	
	 By address=By.name("address1");
	 
	// <input maxlength="60" name="city" size="15">
	 By cityname=By.name("city");
	 
	 //<input maxlength="40" name="state">
	 
	 By statename=By.name("state");
	 
	 //<input maxlength="20" name="postalCode" size="15">
	
	By postalcode=By.name("postalCode");
	
	
	
	Pomconnectors(WebDriver d){
	// this.driver=driver;
		driver = d;
	}
	public void clickregister()
	{
		driver.findElement(register).click();
	}
			
	public void setfirstname( String fname)
	{
		driver.findElement(firstname).sendKeys(fname);
	}
	public void setlastname(String lname)
	{
	driver.findElement(lastname).sendKeys(lname);		
			
	}
		
	public void setphone(String phonenumber)	
	{
		driver.findElement(phone).sendKeys(phonenumber);
	}		
	public void setusername(String sudheer)
	{
	driver.findElement(username).sendKeys(sudheer);
	
    }
	public void setaddress(String madhavapatnam)
	{
	driver.findElement(address).sendKeys(madhavapatnam);
	}
	public void setcityname(String kakinada)
	{
		driver.findElement(cityname).sendKeys(kakinada);
	}
	
	public void setstatename(String andhrapradesh)
	{
		driver.findElement(statename).sendKeys(andhrapradesh);
	}
	public void setpostalcode(String code) 
	{
		driver.findElement(postalcode).sendKeys(code);
	
	}
	
	
	
	
	
	
	
	
}