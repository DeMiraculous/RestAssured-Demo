package CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutRequest {
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
    public void updateAnItemQuantityInCart() {
        // way 1

        // need to add "json" dependency
        JSONObject jsonRequestBody = new JSONObject();
        jsonRequestBody.put("productId", 4643);
        jsonRequestBody.put("quantity", 7);

        // https://simple-grocery-store-api.glitch.me/carts/:cartId/items/:itemId
        String baseURI = "https://simple-grocery-store-api.glitch.me";
        String cartId = "lOakwc6CyH21WAmzbz8j6";
        String itemId = "93115958";
        String endPoint = "/carts/" + cartId + "/items" + itemId;

        RestAssured.baseURI = baseURI;
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonRequestBody.toString());

        Response response = requestSpec.put(endPoint);
        System.out.println(response.getBody().asPrettyString());

        Assert.assertEquals(response.getStatusCode(), "204");

    }
}
