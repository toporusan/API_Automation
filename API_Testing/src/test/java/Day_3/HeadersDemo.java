package Day_3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class HeadersDemo {

    //@Test(priority = 1)
    void testCookies() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()// используется для объединения различных условий или действий в одной цепочке - не обязательно!
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws");

    }

    @Test(priority = 2)
    void getHeader() {

        Response res = given()
                .when()
                .get("https://www.google.com/");

        //get single header info

        String headerValue = res.getHeader("Content-Type");
        System.out.println("The value of the Content-type is: " + headerValue);

    }


}
