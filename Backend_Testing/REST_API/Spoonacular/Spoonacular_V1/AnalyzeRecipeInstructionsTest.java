package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalyzeRecipeInstructionsTest extends AbstractTest {

    @Test
    void dataTypeOfTheResponseTest() {
        JsonPath jsonPath = given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("instructions", "Put the garlic in a pan and then add the onion. "
                        + "Add some salt and oregano")
                .when()
                .post(getBaseUrl()+"recipes/analyzeInstructions")
                .jsonPath();
        assertThat(jsonPath.get().toString(), containsString("Put the garlic in a pan and then add the onion."));
        assertThat(jsonPath.get(), instanceOf(Object.class));
    }
}
