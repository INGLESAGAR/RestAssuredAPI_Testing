package Session13_QueryRequestSpec;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestSpecification {
    @Test
    public void createUser(){
        //create Json Data
        JSONObject jsonData=new JSONObject();
        jsonData.put("name","Sagar");
        jsonData.put("job","QA");

        // create request specification
        RequestSpecification reqSpec= RestAssured.given();

        //specify url
        reqSpec.baseUri("https://reqres.in").
        basePath("/api/users").
     contentType(ContentType.JSON).
                body(jsonData.toJSONString());

        //query details from request specification
        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);

        //get base uri
        String retrieveBaseURI = queryRequest.getBaseUri();
        System.out.println("Base URI:"+retrieveBaseURI);

        //get base path
        String retrieveBasePath = queryRequest.getBasePath();
        System.out.println("Base Path:"+retrieveBasePath);


        //get body
        String retrieveRequestBody = queryRequest.getBody();
        System.out.println("Body"+ retrieveRequestBody);

      // get request Header
       Headers allHeaders= queryRequest.getHeaders();
        System.out.println("\n---------------REQUEST HEADERS------------\n");
       for(Header h:allHeaders)
       {
           System.out.println("Header name:"+ h.getName()+ "Header Value:"+h.getValue());
       }

    }
}
