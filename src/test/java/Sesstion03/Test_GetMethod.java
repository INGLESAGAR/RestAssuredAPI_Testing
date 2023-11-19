package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_GetMethod {
    @Test
    public void test01()
    {
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        System.out.println("Response Code"+ response.getStatusCode());
        System.out.println("Response Body"+ response.getBody().asString());
        System.out.println("Response Time"+ response.getTime());
        System.out.println("Response Header"+ response.getHeader("Content-Type"));

        // Validate status code & Expected status code 200
        int expectedStatusCode=200;
        int ActualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,ActualStatusCode);

    }
    @Test
    public void test02()
    {
        // given ,when , then
        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        RestAssured.given().basePath("booking").when().get().then().statusCode(200);
    }
}
