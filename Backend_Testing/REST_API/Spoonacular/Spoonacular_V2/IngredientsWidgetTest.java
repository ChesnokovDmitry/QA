package org.example.TestSpoonacular_V2;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class IngredientsWidgetTest extends AbstractTest {

    @Test
    void contentTypeHeaderTest() {
        given().spec(getRequestSpecification())
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList", "3 oz flour")
                .formParam("servings", 2)
                .formParam("measure", "metric")
                .formParam("view", "grid")
                .formParam("defaultCss", true)
                .formParam("showBacklink", true)
                .when()
                .post(getBaseUrl()+"recipes/visualizeIngredients")
                .then()
                .spec(getResponseSpecification());
    }
}
