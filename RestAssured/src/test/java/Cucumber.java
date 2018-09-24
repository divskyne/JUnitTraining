import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Cucumber {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private static final String APIKEY = "c9c340db";
	private static final String SEARCH = "Guardians of the Galaxy Vol. 2";
	private static final String IT = "IT";
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() {
		response = request.get("http://www.omdbapi.com/?apikey=" + APIKEY + "&t="+SEARCH);
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
	    json = response.then().statusCode(arg1);
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() {
		response = request.get("http://www.omdbapi.com/?apikey=" + APIKEY + "&t="+IT);
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() {
		json = response.then().body("Rated", equalTo("R"));
	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) {
	    
		response = request.get("http://www.omdbapi.com/?apikey=" + APIKEY + "&t="+arg1);
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) {
		json = response.then().body("Rated", equalTo(arg1));
	}

}
