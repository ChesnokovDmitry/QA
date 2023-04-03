package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties properties = new Properties();
    private static InputStream file;
    private static String baseUrl;
    private static ResponseSpecification responseSpecification;
    private static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() throws IOException {
        file = new FileInputStream("src/main/resources/my.properties");
        properties.load(file);
        baseUrl = properties.getProperty("base_url");

        responseSpecification = new ResponseSpecBuilder()
                .build();

        requestSpecification = new RequestSpecBuilder()
                .build();
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }

    public static ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }
}
