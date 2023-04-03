package org.example.TestSpoonacular_V2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassifyGroceryProductTest extends AbstractTest {

    @Test
    void containsStringResponseTest() {
        Response response = given().spec(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body("{\n"
                        + "\"title\": \"Kroger Vitamin A & D Reduced Fat 2% Milk\",\n"
                        + "\"upc\": \"\",\n"
                        + "\"plu_code\": \"\" }")
                .when()
                .post(getBaseUrl()+"food/products/classify")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get().toString(), containsString("Kroger Vitamin A & D Reduced Fat 2% Milk"));
    }
}
