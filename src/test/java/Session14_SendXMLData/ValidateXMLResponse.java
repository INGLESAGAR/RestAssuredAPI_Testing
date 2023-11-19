package Session14_SendXMLData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateXMLResponse {
    @Test
    public void AddPet()
    {
        String jsonData = "{\n" +
            "  \"id\": 0,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

        // create request specification
        RequestSpecification reqSpec= RestAssured.given();

        //specify url
        reqSpec.baseUri("https://petstore.swagger.io/");
        reqSpec.basePath("/v2/pet");
        reqSpec.header("accept","application/json");
        reqSpec.header("Content-Type","application/json");
        reqSpec.body(jsonData);
        Response response =reqSpec.post();

        response.prettyPrint();
        Assert.assertEquals(response.statusCode() /*actual status code*/,200,"Check for status code");
    }
}
