import org.junit.runner.RunWith;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "parameter.feature")
public class testRunner {
	
	static ExtentReports report = new ExtentReports("report.html",true);
	
}
