package StepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.webstaurent.pages.Homepage;

import Base.BaseClass;
import io.cucumber.java.en.*;
import io.cucumber.java.hu.Ha;



public class StainlessSteel extends BaseClass {
	//Webdriver driver;
	BaseClass bp;
	Homepage hp;
	@Given("user is on the homeopage")
	public void user_is_on_the_homeopage() throws Exception {
		bp=new BaseClass();
		BaseClass.browserinitialization();
		String tit = driver.getTitle();
		Assert.assertEquals(tit,"WebstaurantStore: Restaurant Supplies & Foodservice Equipment");
		
	}
	   
	

	@When("search for stainless worktable")
	public void search_for_stainless_worktable() {
		hp=new Homepage(driver);
		hp.searchinputboxinhomepage();
		hp.searchbuttoninhomepage();
		String tit = driver.getTitle();
		Assert.assertEquals(tit,"Stainless Work Table - WebstaurantStore");
	}
		
	
	@Then("search every product contains text table")
	public void search_every_product_contains_text_table() {
		for(int i=1;i<=9;i++)
		{
			WebElement ele=driver.findElement(By.xpath("//li[contains(@class,'rc-pagination-item-"+i+"')]"));
			ele.click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='details']"));
		
		System.out.println(list.size());
		int count=0;
		for (int j=0; j<list.size(); j++)
		{
			String s = list.get(j).getText();
			
			
			if(s.contains("Table")) {
				//System.out.println("This product contains text Table: "+s);
			}
			else
			{
				 count++;
				System.out.println("This product doesn't contain text Table: "+s);
				System.out.println(count);
			}
		}
	    
	}
	}
	   
	

	@Then("add last item to the cart and delete the item from the cart")
	public void add_last_item_to_the_cart_and_delete_the_item_from_the_cart() {
	    driver.findElement(By.xpath("//div[@data-item-number='650ebs2448']//div[@class='btn-container']/div[1]/input[@name='addToCartButton']")).click();
			
			driver.findElement(By.xpath("//a[@class='btn btn-small btn-primary']")).click();
			
			driver.findElement(By.xpath("//button[@title='Decrease Quantity']")).click();
	}

	
}
