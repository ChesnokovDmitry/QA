package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExtractRecipeFromWebsiteTest extends AbstractTest {

    @Test
    void getExpectedResultIsTrueTest() {
        JsonPath response = given()
                .queryParam("url", "https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies")
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl() + "recipes/extract")
                .jsonPath();
        assertThat(response.get("sourceUrl"),
                containsString("https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies"));
    }
}
