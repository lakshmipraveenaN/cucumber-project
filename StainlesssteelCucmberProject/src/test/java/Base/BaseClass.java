package Base;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver  driver;

	public BaseClass()
	{
		try {
			prop=new Properties();
			FileInputStream fis =new FileInputStream("/Users/chelak/eclipse-workspace/StainlessSteelCucumberProject/src/test/java/Base/config.properties");
			prop.load(fis);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	@BeforeClass
	public static void browserinitialization() throws Exception
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			driver=WebDriverManager.chromedriver().create();
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get(prop.getProperty("url"));
		}
	}
	//@AfterClass
	public void closingbrowser()
	{
	driver.quit();
	}	

}
