package Sesstion03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGetRequest {
   @Test
    void testcases01(){
     Response res= RestAssured.get("https://restful-booker.herokuapp.com/booking");
     System.out.print(res.asString());
       System.out.println("Status Code:"+res.getStatusCode());

   }

}
