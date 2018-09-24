import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class JunitTest   
{
	private Response response;
	private ValidatableResponse json;
	private JSONArray lol;
	private RequestSpecification request;
	@Test
	public void test() 
	{
		 //String title = pm.response.json().Search[0].Title;
		 
//	    given()
//        	.contentType(ContentType.JSON)
//        		.when()
//        			.get(Constants.url+"&s=movie")
//        				.then().statusCode(200);

//		  request = given().contentType(ContentType.JSON);
//		  response = request.when().get(Constants.url+"&t=IT");
//		  System.out.println("response: " + response.prettyPrint());
//		  
//		  response.then().body("Year", equalTo("2017"));
		  
		  request = given().contentType(ContentType.JSON);
		  response =  request.when().get(Constants.url+"&s=movie");
		  ArrayList<String> list = new ArrayList<String>();
		  JSONObject obj = new JSONObject (response.body().asString());
		  //System.out.println(obj.get("Search"));#
		  List<Object> l = obj.getJSONArray("Search").toList();
		  l.stream().filter(o -> l.)
		  JSONArray jArray = obj.getJSONArray("Search");
		  for (Object object : jArray) 
		  {
			  JSONObject o = (JSONObject) object;
			  System.out.println(o.getString("Title"));
		  }  
	}
}
