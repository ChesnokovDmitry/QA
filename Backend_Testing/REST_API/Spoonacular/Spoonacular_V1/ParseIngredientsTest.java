package org.example.Spoonacular_V1;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParseIngredientsTest extends AbstractTest {

    @Test
    void equalsResponseTest() {
        JsonPath jsonPath = given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList", "1 cup green tea")
                .formParam("servings", 1)
                .formParam("includeNutrition", true)
                .when()
                .post(getBaseUrl()+"recipes/parseIngredients")
                .jsonPath();
        assertThat(jsonPath.get("[0].original"), containsString("1 cup green tea"));
        assertThat(jsonPath.get("[0].nutrition.properties[2].name"), equalTo("Nutrition Score"));

        ArrayList<Object> str = jsonPath.get("[0].nutrition.properties");
        assertThat(str.size(), is(3));
    }
}
