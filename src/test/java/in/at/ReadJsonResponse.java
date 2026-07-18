package in.at;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadJsonResponse {
    @Test
    public void readJsonResponse() {

        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        String responsebody = response.getBody().asString();
        System.out.println(responsebody);
    }

    @Test
    public void readJsonBodyAsStringAndValidate() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        String responsebody = response.getBody().asString();
        Assert.assertTrue(responsebody.contains("men's clothing"));
    }

    @Test
    public void readJsonResponseAndValidate() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();
        String category = jsonPath.getString("category");
        String rate = jsonPath.getString("rating.rate");
        System.out.println("category: " + category);
        System.out.println("rating: " + rate);
        Assert.assertEquals(category, "men's clothing");
        Assert.assertEquals(rate, "3.9");


    }
}
