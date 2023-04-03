package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class SearchRecipesTest extends AbstractTest {

    @Test
    void getStatusCodeTest() {
        given()
                .when()
                .get(getBaseUrl() + "recipes/complexSearch?query={pasta}&maxFat={maxFat}&number={number}" +
                        "&apiKey={apiKey}", "pasta", 25, 2, getApiKey())
                .then()
                .statusCode(200);
    }

    @Test
    void getExpectedResultIsTrueTest() {
        JsonPath response = given()
                .queryParam("query", "pasta")
                .queryParam("maxFat", 25)
                .queryParam("number", 2)
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("number"), is(2));
        assertThat(response.get("number"), allOf(lessThan(25)));
    }
}
