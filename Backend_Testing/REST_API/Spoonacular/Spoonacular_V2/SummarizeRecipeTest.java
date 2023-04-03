package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SummarizeRecipeTest extends AbstractTest {

    @Test
    void getBodyMatchesIdTest() {
        Response response = given().spec(getRequestSpecification())
                .pathParam("id", 715538)
                .when()
                .get(getBaseUrl() + "recipes/{id}/summary")
                .then()
                .extract()
                .response();

        assertThat(response.jsonPath().get("id"), equalTo(715538));
    }
}
