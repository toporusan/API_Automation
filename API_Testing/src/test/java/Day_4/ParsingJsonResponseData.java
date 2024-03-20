package Day_4;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ParsingJsonResponseData {

    @Test(priority = 1)
    void testJsonResponse() {

        //Approach 1
        given()
                .contentType("ContentType/JSON")
                .when()
                .get("http://localhost:3000/books")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .log();
                //.body("books[2].title", equalTo("To Kill a Mockingbird"));

    }

}
