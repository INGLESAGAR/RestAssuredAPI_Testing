package Session04_ResponseStatus;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class CheckForValidateResponse_1 {
    @Test
    public void GetSingleUser_BDDStyle(){
        given()
                .when()
                      .get("https://reqres.in/api/users/2")
                . then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all();
    }
}
