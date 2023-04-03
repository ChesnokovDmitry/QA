package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SummarizeRecipeTest extends AbstractTest {

    @Test
    void getBodyMatchesIdTest() {
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .pathParam("id", 715538)
                .when()
                .get(getBaseUrl() + "recipes/{id}/summary")
                .jsonPath();

        assertThat(response.get("id"), equalTo(715538));
    }
}
