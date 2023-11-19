package Session08_Authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.apache.commons.codec.binary.Base64;
public class Authorization
{
    @Test
    public void BasicAuth()
    {
        RequestSpecification requestSpec= RestAssured.given();
        //specify url
        requestSpec.baseUri("http://postman-echo.com");
        requestSpec.basePath("/basic-auth");

        //perform get request
        Response response= requestSpec.auth().basic("postman","password").get();

        System.out.println("Response Status:"+response.statusLine());
        System.out.println(Base64.class.getProtectionDomain().getCodeSource().getLocation());

    }
}
