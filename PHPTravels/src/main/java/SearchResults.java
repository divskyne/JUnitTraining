import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults {
	
	@FindBy(xpath="//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div")
	List<WebElement> results;

}