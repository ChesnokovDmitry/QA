package org.example.Spoonacular_V1;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRecipeInformationBulkTest extends AbstractTest {

    @Test
    void getStatusAndContentTypeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("ids", 715538, 716429)
                .when()
                .get(getBaseUrl() + "recipes/informationBulk")
                .then()
                .assertThat()
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);
    }
}
