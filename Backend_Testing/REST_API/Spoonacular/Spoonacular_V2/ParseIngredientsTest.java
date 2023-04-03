package org.example.TestSpoonacular_V2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParseIngredientsTest extends AbstractTest {

    @Test
    void equalsResponseTest() {
        Response response = given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList", "1 cup green tea")
                .formParam("servings", 1)
                .formParam("includeNutrition", true)
                .when()
                .post(getBaseUrl()+"recipes/parseIngredients")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("[0].original"), containsString("1 cup green tea"));
        assertThat(response.jsonPath().get("[0].nutrition.properties[2].name"), equalTo("Nutrition Score"));

        ArrayList<Object> str = response.jsonPath().get("[0].nutrition.properties");
        assertThat(str.size(), is(3));
    }
}
