package Session04_ResponseStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckForValidateResponse {
    //https://reqres.in/api/users/2\
    @Test(enabled = false)
    public void  GetSingleUser()
    {
        //Specify base url
        RestAssured.baseURI="https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec =RestAssured.given();

        //call get method
        Response response=requestSpec.get();

        //get response code
        int statuscode= response.getStatusCode();

        //validate actual status code with expected
//Assert.assertEquals(statuscode ,200);

        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","Incorrect status line");


    }


    @Test
    public void  GetSingleUserUsingValidatableResponse()
    {
        //Specify base url
        RestAssured.baseURI="https://reqres.in/api/users/2";

        //Get Request specification of the request
        RequestSpecification requestSpec =RestAssured.given();

        //call get method
        Response response=requestSpec.get();
        ValidatableResponse validateRes=response.then();
        //status code
        validateRes.statusCode(200);

        //status line
        validateRes.statusLine("HTTP/1.1 200 OK");
        validateRes.log().all();


    }
}
