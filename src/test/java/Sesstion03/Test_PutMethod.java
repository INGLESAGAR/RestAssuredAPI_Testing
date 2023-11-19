package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PutMethod {

    @Test
    public void test04()
    {
        JSONObject jsonData= new JSONObject();
        jsonData.put("name","Saurabh");
        jsonData.put("job","QA Test Engineer");

        RestAssured.baseURI="https://reqres.in/api/users/607";
        RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).
                body(jsonData.toJSONString()).
                when().put().
                then().statusCode(200).log().all();
    }
}
