package Day_4;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ParsingJsonResponseDataTest {

    @Test(priority = 1)
    void testJsonResponse() {

        //Approach 1
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/books")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("books[0].title", equalTo("1984"));


    }

}
