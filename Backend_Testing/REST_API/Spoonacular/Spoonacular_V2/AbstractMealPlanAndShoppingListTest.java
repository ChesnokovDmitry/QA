package org.example.TestSpoonacular_V2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractMealPlanAndShoppingListTest {
    static Properties properties = new Properties();
    private static InputStream file;
    private static String apiKey;
    private static String baseUrl;
    private static String hash;
    private static String username;
    private static ResponseSpecification responseSpecification;
    private static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() throws IOException {
        file = new FileInputStream("src/main/resources/my.properties");
        properties.load(file);
        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("base_url");
        username = properties.getProperty("username");
        hash = properties.getProperty("hash");

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", hash)
                .addPathParam("username", username)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getHash() {
        return hash;
    }

    public static String getUsername() {
        return username;
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }
}
