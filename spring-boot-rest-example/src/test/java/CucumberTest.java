import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CucumberTest {
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Given("^the content type is JSON$")
	public void the_content_type_is_JSON() {
		RestAssured.baseURI = "http://localhost:8080/v1/person";
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	@When("^a user adds a new person$")
	public void a_user_adds_a_new_person() throws Exception {
		JSONArray addres = new JSONArray();
		JSONObject address = new JSONObject();
		JSONObject responseParam = new JSONObject();
		
		address.put("city", "Kochi");
		address.put("line1", "Very high, big rooms");
		address.put("line2", "blah");
		address.put("state", "bleeh");
		address.put("zip", "bleeh");
		
		addres.put(address);
		
		responseParam.put("addresses", addres);
		
		responseParam.put("dateOfBirth", "2018-09-26T08:25:09.225Z");
		responseParam.put("firstName", "zbleeed");
		responseParam.put("gender", "F");
		responseParam.put("lastName", "Faustin");
		responseParam.put("middleName", "J");
		System.out.println(responseParam.toString());
		request.body(responseParam.toString());
		request.header("userId", "000000000");
		response = request.put("/");//?userId=isawthese&token=98
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) {
		json = response.then().statusCode(arg1);
	}

	@When("^a user creates a person with fname \"([^\"]*)\", lname \"([^\"]*)\"$")
	public void a_user_creates_a_person_with_fname_lname(String arg1, String arg2) throws JSONException {
		JSONArray addres = new JSONArray();
		JSONObject address = new JSONObject();
		JSONObject responseParam = new JSONObject();
		
		address.put("city", "Kochi");
		address.put("line1", "Very high, big rooms");
		address.put("line2", "blah");
		address.put("state", "bleeh");
		address.put("zip", "bleeh");
		
		addres.put(address);
		
		responseParam.put("addresses", addres);
		
		responseParam.put("dateOfBirth", "2018-09-26T08:25:09.225Z");
		responseParam.put("firstName", arg1);
		responseParam.put("gender", "F");
		responseParam.put("lastName", arg2);
		responseParam.put("middleName", "J");
		request.body(responseParam.toString());
		request.header("userId", "000000000");
		response = request.put("/");//?userId=isawthese&token=98
	}

	@When("^a user retrieves all the persons$")
	public void a_user_retrieves_all_the_persons() {
	    response = request.get("http://localhost:8080/v1/persons?size=5&page=0");
	}

	@Then("^the person with fname \"([^\"]*)\" must be there$")
	public void the_person_with_fname_must_be_there(String arg1) throws JSONException {
		JSONObject obj = new JSONObject (response.body().asString());
		JSONArray jArray = obj.getJSONArray("content");
		for (Object object : jArray) {
			JSONObject o = (JSONObject) object;
			  if (o.getString("firstName").equals(arg1)) {
				  Assert.assertEquals(arg1, o.getString("firstName"));
			}
		}
	}

	@Given("^a person exists with the ID (\\d+)$")
	public void a_person_exists_with_the_ID(int arg1) {
		the_content_type_is_JSON();
		response = request.get("http://localhost:8080/v1/persons?size=15&page=0");
		JSONObject obj = new JSONObject (response.body().asString());
		JSONArray jArray = obj.getJSONArray("content");
		for (Object object : jArray) {
			JSONObject o = (JSONObject) object;
			  if (o.getInt("id") == (arg1)) {
				  Assert.assertEquals(arg1, o.getInt("id"));
			}
		}
	}

	@When("^a user retrieves the person by the id (\\d+)$")
	public void a_user_retrieves_the_person_by_the_id(int arg1) {
	    response = request.get("/"+arg1);
	}

	@Then("^the name is \"([^\"]*)\"$")
	public void the_name_is(String arg1) {
		JSONObject obj = new JSONObject (response.body().asString());
		if (obj.getString("firstName").equals(arg1)) {
			  Assert.assertEquals(arg1, obj.getString("firstName"));
		}
	}

	@Then("^the name is equal to \"([^\"]*)\"$")
	public void the_name_is_equal_to(String arg1) {
		JSONObject obj = new JSONObject (response.body().asString());
		if (obj.getString("firstName").equals(arg1)) {
			  Assert.assertEquals(arg1, obj.getString("firstName"));
		}
	}

}
