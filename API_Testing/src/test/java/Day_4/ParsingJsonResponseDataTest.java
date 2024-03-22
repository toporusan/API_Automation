package Day_4;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;


public class ParsingJsonResponseDataTest {

    @Test(priority = 1)
    void testJsonResponse() {

        //Approach 1
        /*given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/books")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("books[0].title", equalTo("1984"));*/


        //Approach 2

        Response res = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/book");

      /*  Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json");

        String title = res.jsonPath().get("[3].title").toString();// получаем title четвертого объекта
        Assert.assertEquals(title,"One Hundred Years of Solitude");
        System.out.println(title);*/


        // JSONObject Class -представляет собой контейнер для хранения
        // и работы с данными в формате JSON

        JSONObject jo = new JSONObject(res.toString());// converting response to json object type











    }


}
