package Sesstion03;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class WithoutRestAssuredClass_UsingMethod {

    @Test
    public void test01()
    {
        // given ,when , then
        baseURI="https://restful-booker.herokuapp.com/";
        given().basePath("booking").when().get().then().statusCode(200);
    }

}
