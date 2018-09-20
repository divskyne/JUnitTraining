import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

    @Test
    public void testGuru99TakeScreenShot() throws Exception{

		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

        driver.get("http://www.google.com");

        System.out.println(this.takeSnapShot(driver));
        driver.quit();
    }

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public String takeSnapShot(WebDriver webdriver) throws Exception
    {
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        
        Path fileToMovePath = Paths.get(srcFile.getPath());
        
        Path targetPath = Paths.get("src/main/resources/");
        Path imagepath = Files.move(fileToMovePath, targetPath.resolve(fileToMovePath.getFileName()));
        return "";
    }
}
