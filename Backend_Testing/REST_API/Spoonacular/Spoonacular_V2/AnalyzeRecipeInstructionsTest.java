package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalyzeRecipeInstructionsTest extends AbstractTest {

    @Test
    void dataTypeOfTheResponseTest() {
        Response response = given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("instructions", "Put the garlic in a pan and then add the onion. "
                        + "Add some salt and oregano")
                .when()
                .post(getBaseUrl()+"recipes/analyzeInstructions")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get().toString(), containsString("Put the garlic in a pan and then add the onion."));
        assertThat(response.jsonPath().get(), instanceOf(Object.class));
    }
}
