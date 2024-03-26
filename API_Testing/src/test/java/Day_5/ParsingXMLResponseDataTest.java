package Day_5;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class ParsingXMLResponseDataTest {
    private WireMockServer wireMockServer;

    @BeforeTest
    public void setup() {
        wireMockServer = new WireMockServer(); // Создание нового сервера
        wireMockServer.start(); // Запуск сервера
        WireMock.configureFor("localhost", wireMockServer.port()); // Настройка клиента на работу с сервером
    }

    @AfterTest
    public void teardown() {
        wireMockServer.stop(); // Остановка сервера
    }

    @Test
    void test() {
/*        File f = new File("D:/0.Practice/API_Automation/API_Testing/JsonFiles/travelers.xml");
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            // Читаем содержимое файла построчно
            String line;
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuffer);*/

        stubFor(get(urlEqualTo(""))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBodyFile("D:/0.Practice/API_Automation/API_Testing/JsonFiles/travelers.xml")));
        //.withHeader("Content-Type", "application/xml")
        // .withBody("<YourXmlResponseObject><field1>Value1</field1><field2>Value2</field2></YourXmlResponseObject>")));

    }
}
