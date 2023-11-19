package Session12_Deserialize;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationJsonDemo {
    @Test
    public void createUser()
    {
        RequestSpecification requestSpec= RestAssured.given();
        //specify url
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users");

        //create request body
        JSONObject jsondata=new JSONObject();
        jsondata.put("name","sagar");
        jsondata.put("job","QA");

        //perform post request

        Response response= requestSpec.contentType(ContentType.JSON).body(jsondata.toJSONString()).post();

        ResponseBody responseBody=response.getBody();

        //Deserialize responseBody i.e json response boy to class object
        JSONPostRequestResponse responseClass=responseBody.as(JSONPostRequestResponse.class);

        Assert.assertEquals(responseClass.name,"sagar","check for name");
        Assert.assertEquals(responseClass.job,"QA","check for Job");

    }
}
