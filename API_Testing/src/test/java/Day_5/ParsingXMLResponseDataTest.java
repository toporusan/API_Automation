package Day_5;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;


public class ParsingXMLResponseDataTest {

    @Test
    void testXMLResponse() {
        //Approach 1

        /*given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                .statusCode(200)
                .header("Content-type", "application/xml")
                .body("TravelerinformationResponse.page", equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay Bharath Reddy"));*/

        Response res = given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-type"),"application/xml");

        String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();



        Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.page").toString().body("Content-type"),"application/xml");




    }
}
