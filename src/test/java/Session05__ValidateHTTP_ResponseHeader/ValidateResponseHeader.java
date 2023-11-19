package Session05__ValidateHTTP_ResponseHeader;

import io.restassured.RestAssured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ValidateResponseHeader {
    @Test
    public void GetSingleUser()
    {
        RequestSpecification requestSpec= RestAssured.given();

        //base uri https://reqres.in
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users/2");

        //create get request
        Response response=requestSpec.get();

        //validate response header

        //1.Content-Type
      //  String contentType=response.header("Content-Type");
       // System.out.println(contentType);

        //2.Connection
       // String Connection=response.header("Connection");
        //System.out.println(Connection);

        // Read all the response header attributes / Key and print there values
        Headers headerslist =response.getHeaders();

        for(Header header:headerslist)
        {
            System.out.println(header.getName()+ "::"+ header.getValue());
        }
    }
}
