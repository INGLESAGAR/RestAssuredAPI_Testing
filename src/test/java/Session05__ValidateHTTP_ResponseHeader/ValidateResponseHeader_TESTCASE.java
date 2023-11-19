package Session05__ValidateHTTP_ResponseHeader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseHeader_TESTCASE {
    @Test
    public void GetSingleUser() {
        RequestSpecification requestSpec = RestAssured.given();

        //base uri https://reqres.in
        requestSpec.baseUri("https://reqres.in");
        requestSpec.basePath("/api/users/2");

        //create get request
        Response response = requestSpec.get();

        String contentType=response.header("Content-Type");
        System.out.println(contentType);

        //Header content Type Mismatch.---Error
        Assert.assertEquals(contentType,"application/json; charset=utf-8","Header content Type Mismatch.");



    }
}
