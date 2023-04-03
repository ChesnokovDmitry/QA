package org.example.TestSpoonacular_V2;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRecipeInformationBulkTest extends AbstractTest {

    @Test
    void getStatusAndContentTypeTest() {
        given().spec(getRequestSpecification())
                .queryParam("ids", 715538, 716429)
                .when()
                .get(getBaseUrl() + "recipes/informationBulk")
                .then()
                .spec(getResponseSpecification())
                .contentType(ContentType.JSON);
    }
}
