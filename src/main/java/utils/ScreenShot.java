package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String takeScreenShot(WebDriver driver, String testName, String path) {

		String timeStamp = LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String fileName = testName + timeStamp+".png";
		String filePath = System.getProperty("user.dir")+"./Screenshots/"+path+"/";
		
		File folderpath = new File(filePath);
		//Create if no folder is present
		if (!folderpath.exists()) {
			folderpath.mkdirs();
		}
		
		//ScreenShot
		String ScreenshotPath = filePath+fileName;
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ScreenshotPath);
		
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ScreenshotPath;
		
	}
}
