package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PatchMethod {
    @Test
    public void test05()
    {
        JSONObject jsonData= new JSONObject();
        jsonData.put("name","Kailas");
        jsonData.put("job","QA Manager");

        RestAssured.baseURI="https://reqres.in/api/users/607";
        RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).
                body(jsonData.toJSONString()).
                when().patch().then().statusCode(200).log().all();
    }
}
