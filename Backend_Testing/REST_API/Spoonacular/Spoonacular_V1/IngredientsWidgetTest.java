package org.example.Spoonacular_V1;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class IngredientsWidgetTest extends AbstractTest {

    @Test
    void contentTypeHeaderTest() {
        Response response = given()
                .queryParam("apiKey", getApiKey())
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
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("text/html")
                .extract().response();
    }
}
