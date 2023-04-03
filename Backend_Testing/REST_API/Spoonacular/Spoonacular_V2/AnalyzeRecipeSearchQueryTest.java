package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalyzeRecipeSearchQueryTest extends AbstractTest {

    @Test
    void getRecipeContainsIngredientFusilliTest() {
        Response response = given().spec(getRequestSpecification())
                .queryParam("q", "salmon+with+fusilli+and+no+nuts")
                .when()
                .get(getBaseUrl() + "recipes/queries/analyze")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("ingredients[0].include"), is(true));
        assertThat(response.jsonPath().get("ingredients[1].include"), not(true));
    }
}
