import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class simpleRestAssured {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private static final String APIKEY = "c9c340db";
	
	@Test
	public void exampleRestTestWhichShould200() {
		
	    given()
	        .contentType(ContentType.JSON)
	    .when()
	        .get("http://www.omdbapi.com/?apikey="+APIKEY+"&t=IT&y=2017")
	    .then().statusCode(200).body("Rated", equalTo("R"));
	    
	    request = given().contentType(ContentType.JSON);
	    response = request.when().get("http://www.omdbapi.com/?apikey="+APIKEY+"&t=IT&y=2017");
	    System.out.println("response: " + response.prettyPrint());   
	}
}
