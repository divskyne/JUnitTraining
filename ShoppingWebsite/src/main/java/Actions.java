import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Actions {
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[1]")
	private WebElement resultSearch;
	
	public String getResultSearch() {
		return trimStringByString(resultSearch.getText(),"\"");
	}

	public void search(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
	}
	
	public String trimStringByString(String text, String trimBy) {
	    int beginIndex = 0;
	    int endIndex = text.length();

	    while (text.substring(beginIndex, endIndex).startsWith(trimBy)) {
	        beginIndex += trimBy.length();
	    } 

	    while (text.substring(beginIndex, endIndex).endsWith(trimBy)) {
	        endIndex -= trimBy.length();
	    }

	    return text.substring(beginIndex, endIndex);
	}
	
}
