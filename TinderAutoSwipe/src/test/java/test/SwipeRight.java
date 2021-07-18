package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

public class SwipeRight extends BaseClass
{
	Logger logger = LogManager.getLogger(this.getClass());
	
	@Test
	public void swipeRight() throws Exception
	{
		Waiting.withID("com.tinder:id/requestPermissionButton", 10);
		driver.findElement(By.id("com.tinder:id/requestPermissionButton")).click();
		logger.info("Clicked Location Permission button");
		
		Waiting.withID("com.android.packageinstaller:id/permission_allow_button", 5);
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		logger.info("Clicked Allow button");
		
		Waiting.withID("com.tinder:id/gamepad_like", 5);
		int swipe = 1;
		while(true)
		{
			driver.findElement(By.id("com.tinder:id/gamepad_like")).click();
			logger.info("Swipe Right Count: " + swipe);
			swipe++;
		}
		
	}

	
}
