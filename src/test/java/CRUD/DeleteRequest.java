package CRUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequest {
    @Test
    public void getAllItemsFromTheCart() {

        // https://simple-grocery-store-api.glitch.me/carts/:cartId/items

        String baseURI = "https://simple-grocery-store-api.glitch.me";
        String cartId = "lOakwc6CyH21WAmzbz8j6";

        String endPoint = "/carts/" + cartId + "/items";

        RestAssured.given()
                .baseUri(baseURI)
                .get(endPoint)
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test
    public void deleteAnItemInCart() {

        // https://simple-grocery-store-api.glitch.me/carts/:cartId/items/:itemId
        String baseURI = "https://simple-grocery-store-api.glitch.me";
        String cartId = "lOakwc6CyH21WAmzbz8j6";
        String itemId = "11974331";
        String endPoint = "/carts/" + cartId + "/items/" + itemId;

        // way 1
        RestAssured.baseURI = baseURI;
        RequestSpecification requestSpec = RestAssured.given();

        Response response = requestSpec.delete(endPoint);

        Assert.assertEquals(response.statusCode(), 204);

        // way 2
//        RestAssured.given()
//                .baseUri(baseURI)
//                .when()
//                .delete(endPoint)
//                .then()
//                .statusCode(204);

    }
}
