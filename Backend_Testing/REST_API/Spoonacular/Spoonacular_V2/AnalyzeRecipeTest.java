package org.example.TestSpoonacular_V2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnalyzeRecipeTest extends AbstractTest {

    @Test
    void dataTypeOfTheResponseTest() {
        Response response = given().spec(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body("{\n"
                        + "\"title\": \"Spaghetti Carbonara\",\n"
                        + "\"servings\": 2,\n"
                        + "\"ingredients\": [\n"
                            + "\"1 lb spaghetti\",\n"
                            + "\"3.5 oz pancetta\",\n"
                            + "\"2 Tbsps olive oil\",\n"
                            + "\"1  egg\",\n"
                            + "\"0.5 cup parmesan cheese\"\n"
                        + "],\n"
                        + "\"instructions\": \"Bring a large pot of water to a boil and season generously with salt. "
                        + "Add the pasta to the water once boiling and cook until al dente. "
                        + "Reserve 2 cups of cooking water and drain the pasta.\"\n"
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/analyze")
                .then()
                .extract().response();

        assertThat(response.jsonPath().get("originalId"), nullValue());
        assertThat(response.jsonPath().get("instructions"), instanceOf(String.class));
        assertThat(response.jsonPath().get("extendedIngredients"), instanceOf(ArrayList.class));
        assertThat(response.jsonPath().get("healthScore"), instanceOf(Integer.class));
    }
}
