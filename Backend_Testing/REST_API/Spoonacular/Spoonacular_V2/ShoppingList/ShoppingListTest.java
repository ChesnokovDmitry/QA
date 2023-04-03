package org.example.TestedClassesLesson4.ShoppingList;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.Spoonacular_V2.RequestShoppingList;
import org.example.Spoonacular_V2.ResponseShoppingList;
import org.example.TestedClassesLesson4.AbstractMealPlanAndShoppingListTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ShoppingListTest extends AbstractMealPlanAndShoppingListTest {

    @Test
    void addGetDeleteFromShoppingListTest() {
        RequestShoppingList request = new RequestShoppingList();
        request.setItem("1 package baking powder");
        request.setAisle("Baking");
        request.setParse(true);

        ResponseShoppingList response = given().spec(getRequestSpecification()).body(request)
                .when()
                .post(getBaseUrl() + "mealplanner/{username}/shopping-list/items").prettyPeek()
                .then()
                .spec(getResponseSpecification())
                .extract()
                .response()
                .body()
                .as(ResponseShoppingList.class);

        given().spec(getRequestSpecification())
                .when()
                .get(getBaseUrl() + "mealplanner/{username}/shopping-list").prettyPeek()
                .then()
                .spec(getResponseSpecification());

        given().spec(getRequestSpecification())
                .when()
                .delete(getBaseUrl() + "mealplanner/{username}/shopping-list/items/" + response.getId()).prettyPeek()
                .then()
                .spec(getResponseSpecification());
    }
}
