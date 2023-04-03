package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class SearchRecipesTest extends AbstractTest {

    @Test
    void getExpectedResultIsTrueTest() {
        Response response = given().spec(getRequestSpecification())
                .queryParam("query", "pasta")
                .queryParam("maxFat", 25)
                .queryParam("number", 2)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("number"), is(2));
        assertThat(response.jsonPath().get("number"), allOf(lessThan(25)));
    }
}
