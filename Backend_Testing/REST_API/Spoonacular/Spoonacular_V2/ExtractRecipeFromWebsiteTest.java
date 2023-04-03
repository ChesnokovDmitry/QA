package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExtractRecipeFromWebsiteTest extends AbstractTest {

    @Test
    void getExpectedResultIsTrueTest() {
        Response response = given().spec(getRequestSpecification())
                .queryParam("url", "https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies")
                .when()
                .get(getBaseUrl() + "recipes/extract")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("sourceUrl"),
                containsString("https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies"));
    }
}
