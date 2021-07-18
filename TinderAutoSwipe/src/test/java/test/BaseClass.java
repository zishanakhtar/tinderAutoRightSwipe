package test;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.*;

public class BaseClass //extends ExtentTestReport
{
	static AppiumDriver<WebElement> driver;

	@BeforeSuite
	public static void openApp() throws Exception
	{
		Logger logger = LogManager.getLogger(BaseClass.class);
		DesiredCapabilities capMB = new DesiredCapabilities();
		
		capMB.setCapability("deviceName", "Samsung M51");
		//capMB.setCapability("udid", "192.168.0.106:5555");		//Samsung M51
		//capMB.setCapability("udid", "emulator-5554");		//Emulator
		capMB.setCapability("udid", "A2QDU17617002044");		//Honor 6x
		capMB.setCapability("platformName", "Android");
		capMB.setCapability("platformVersion", "11");
		capMB.setCapability("newCommandTimeout", 60 * 5);		//prevents application from force stop

		capMB.setCapability("appPackage", "com.tinder");
		//capMB.setCapability(“autoGrantPermissions", "true");
		capMB.setCapability("appActivity", "com.tinder.activities.LoginActivity");

		URL urlMB = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<WebElement>(urlMB, capMB);
		AppDriver.setDriver(driver);

		//System.out.println("App Started");
		logger.info("App Started");
		Thread.sleep(5000);
	}

	@AfterSuite
	public static void tearDown()
	{
		driver.quit();
	}
	

/*	public static void relaunch() throws Exception
	{
		Thread.sleep(500);
		driver.terminateApp("in.medibuddy");
		Thread.sleep(1000);
		driver.activateApp("in.medibuddy");
		Waiting.withID("in.medibuddy:id/imghamburMenu", 120);
		Waiting.withID("in.medibuddy:id/ll_talkToDoctor", 120);
		Thread.sleep(500);
	} */

}
