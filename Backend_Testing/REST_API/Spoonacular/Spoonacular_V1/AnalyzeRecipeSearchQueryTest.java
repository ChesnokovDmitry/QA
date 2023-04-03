package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalyzeRecipeSearchQueryTest extends AbstractTest {

    @Test
    void getRecipeContainsIngredientFusilliTest() {
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("q", "salmon+with+fusilli+and+no+nuts")
                .when()
                .get(getBaseUrl() + "recipes/queries/analyze")
                .jsonPath();

        assertThat(response.get("ingredients[0].include"), is(true));
        assertThat(response.get("ingredients[1].include"), not(true));
    }
}
