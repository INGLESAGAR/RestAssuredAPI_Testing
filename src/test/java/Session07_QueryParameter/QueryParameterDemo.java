package Session07_QueryParameter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueryParameterDemo {

    @Test
    public void filterData(){
        //Get request specification for the  given request
        RequestSpecification requestSpec= RestAssured.given();

        //specify url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("api/users");
        //requestSpec.queryParam("page",2); //all page 2 data

        requestSpec.queryParam("page",2).queryParam("id",4); //only one user data

        //perform get request
       Response response= requestSpec.get();

       // read response body
       String responsebodystring = response.getBody().asString();


         //print response body
       System.out.println("Response body:"+responsebodystring);

        //get json  path view of response body
        JsonPath jsonPathView = response.jsonPath();
        //x.data.id
        int id = jsonPathView.get("data.id");
        Assert.assertEquals(4, 4, "Check for presense of id");
    }
}
