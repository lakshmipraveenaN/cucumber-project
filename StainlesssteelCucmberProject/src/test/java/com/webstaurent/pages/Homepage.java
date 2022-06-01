package com.webstaurent.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	 static WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 By searchbox=By.xpath("//input[@id='searchval']");
	 By searchbutton=By.xpath("//button[@value='Search']");
	 public void searchinputboxinhomepage()
	 {
		 driver.findElement(searchbox).sendKeys("stainless work table");
	 }
	 public void searchbuttoninhomepage()
	 {
		 driver.findElement(searchbutton).click();
	 }
	
	

}
