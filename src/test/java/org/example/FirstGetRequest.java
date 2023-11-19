package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class FirstGetRequest {
   @Test
    void testcases01(){
     Response res= RestAssured.get("https://restful-booker.herokuapp.com/booking");
     System.out.print(res.asString());
       System.out.println("Status Code:"+res.getStatusCode());

   }

}
