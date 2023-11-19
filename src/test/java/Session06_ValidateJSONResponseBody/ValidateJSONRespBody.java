package Session06_ValidateJSONResponseBody;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateJSONRespBody {
    @Test
    public void UserListResponseBody() {
        //Get RequestSpecification Reference
        RequestSpecification requestSpec = RestAssured.given();

        //Specify base URI & Base path
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("api/users?page=2");

        //Create get request
        Response response = requestSpec.get();

        //Read response Body
        ResponseBody responseBody = response.getBody();

     /*String responseString =responsebody.asString();

     System.out.println("ResponseBody:"+responseString);

     //Check for presence of Ramos in response  body
        Assert.assertEquals(responseString.contains("Ramos"),true,"Check for prence of Ramos");
 */

        //get json  path view of response body
        JsonPath jsonPathView = responseBody.jsonPath();
        //x.data[4].first_name
        String firstName = jsonPathView.get("data[0].first_name");
        Assert.assertEquals(firstName, "George", "Check for presense of firstname");
    }
}














































