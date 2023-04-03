package org.example.Spoonacular_V1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToMealPlanAndDeleteTest extends AbstractTest {

    @Test
    void addToMeelPlanAndDeleteTest() {
        String hash = "91e8253fc82c1b8aff7c6dc2d51c1c87389e4b9f";
        String username = "dmitry0";

        String id = given()
                .queryParam("apiKey", getApiKey())
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"date\": 1589500800,\n" +
                        "    \"slot\": 1,\n" +
                        "    \"position\": 0,\n" +
                        "    \"type\": \"INGREDIENTS\",\n" +
                        "    \"value\": {\n" +
                        "        \"ingredients\": [\n" +
                        "            {\n" +
                        "                \"name\": \"1 banana\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}")
                .queryParam("hash", hash)
                .pathParam("username", username)
                .when()
                .post(getBaseUrl()+"mealplanner/{username}/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", hash)
                .pathParam("username", username)
                .when()
                .delete(getBaseUrl()+"mealplanner/{username}/items/" + id)
                .then()
                .statusCode(200);
    }
}
