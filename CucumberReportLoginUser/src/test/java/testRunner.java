import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\")
public class testRunner
{	
	static ExtentReports report = new ExtentReports("src/test/resources/report.html",true);
}
