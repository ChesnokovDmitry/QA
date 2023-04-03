package org.example.Spoonacular_V1;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties properties = new Properties();
    private static InputStream file;
    private static String apiKey;
    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        file = new FileInputStream("src/main/resources/my.properties");
        properties.load(file);
        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("base_url");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
