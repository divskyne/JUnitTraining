package com.qa.dependencies;
/**
 * @author divine 2018-09-20
 */

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class Helpers
{
	public static String takeScreenshot(WebDriver webdriver, String path) throws Exception
	{
		TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		Files.copy(source, destination);
		return path;
	}
}
