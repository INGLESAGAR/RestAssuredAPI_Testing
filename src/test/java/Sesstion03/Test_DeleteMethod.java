package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Test_DeleteMethod {
    @Test
    public void test06()
    {
        RestAssured.baseURI="https://reqres.in/api/users/607";

               RestAssured. when().delete().then().statusCode(204).log().all();
    }
}
