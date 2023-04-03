package org.example.Spoonacular_V1;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassifyGroceryProductTest extends AbstractTest {

    @Test
    void containsStringResponseTest() {
        JsonPath jsonPath = given()
                .queryParam("apiKey", getApiKey())
                .contentType(ContentType.JSON)
                .body("{\n"
                        + "\"title\": \"Kroger Vitamin A & D Reduced Fat 2% Milk\",\n"
                        + "\"upc\": \"\",\n"
                        + "\"plu_code\": \"\" }")
                .when()
                .post(getBaseUrl()+"food/products/classify")
                .jsonPath();
        assertThat(jsonPath.get().toString(), containsString("Kroger Vitamin A & D Reduced Fat 2% Milk"));
    }
}
