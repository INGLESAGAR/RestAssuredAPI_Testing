package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PostMethod {
    @Test
    public void test03()
    {
        JSONObject jsonData= new JSONObject();
        jsonData.put("name","Sagar");
        jsonData.put("job","QA Fresher");

        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).
         body(jsonData.toJSONString()).
         when().post().
                then().statusCode(201).log().all();

        //Response console log after then() Method



    }
}
