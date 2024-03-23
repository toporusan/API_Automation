package Day_4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;


public class ParsingJsonResponseDataTest {

    @Test(priority = 1)
    void testJsonResponse() {

        //Approach 1
      /*  given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/books")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("books[0].title", equalTo("1984"));*/


        //Approach 2

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/book");

      /*  Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/json");

        String title = res.jsonPath().get("[3].title").toString();// получаем title четвертого объекта
        Assert.assertEquals(title,"One Hundred Years of Solitude");
        System.out.println(title);*/


        // JSONObject Class -представляет собой контейнер для хранения и работы с данными в формате JSON

        String a = res.getBody().asPrettyString(); // получили тело (массив объектов)

        JSONArray jsonArray = new JSONArray(a); // Создали JSONArray (объект) из строки

        JSONObject jo = new JSONObject();// Создали новый JSONObject();
        jo.put("book", jsonArray); // присвоили ему объект с ключем "book" и значением jsonArray

        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {

            String booKTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(booKTitle);
        }


    }


}
