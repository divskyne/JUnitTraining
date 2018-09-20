import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	
	private static final String screenshotFolder = "src/main/resources/";
	
	/**

     * This function will take a screenshot and return the path to it as a String

     * @param webdriver

     * @throws Exception

     * @returns String -> image path

     */
	
	public String takeSnapShot(WebDriver webdriver)
    {
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        Path fileToMovePath = Paths.get(srcFile.getPath());
        Path targetPath = Paths.get(screenshotFolder);
        Path imagepath = null;
		try {
			imagepath = Files.move(fileToMovePath, targetPath.resolve(fileToMovePath.getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
        return imagepath.toFile().getAbsolutePath();
    }
}
