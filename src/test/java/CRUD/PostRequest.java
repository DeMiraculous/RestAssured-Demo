package CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testData.POJOClass;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PostRequest {
    @Test
    public void addProductUsingJSONasString() {
        String jsonRequestBodyAsString = "{\"title\": \"Laptop\",\"price\": \"100\",\"description\": \"Best Laptop\", \"categories\": \"electronics\"}";

        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonRequestBodyAsString);

        Response response = requestSpec.post();
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void addProductMap() {
        //add gson depencency in pom.xml
        Map<String, String> jsonRequestBodyAsMap = new HashMap();
        jsonRequestBodyAsMap.put("title", "Laptop");
        jsonRequestBodyAsMap.put("price", "150");
        jsonRequestBodyAsMap.put("description", "Best Laptop");
        jsonRequestBodyAsMap.put("category", "electronic");

        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonRequestBodyAsMap);

        Response response = requestSpec.post();
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void addProductJSONobject() {
        JSONObject jsonRequestBody = new JSONObject();
        jsonRequestBody.put("title", "Laptop");
        jsonRequestBody.put("price", "200");
        jsonRequestBody.put("description", "Best Laptop");
        jsonRequestBody.put("category", "electronic");

// way 1
        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(jsonRequestBody.toString());

        Response response = requestSpec.post();
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void addProductPOJOclass() {
        POJOClass pojoRequest = new POJOClass();
        pojoRequest.setTitle("Laptop");
        pojoRequest.setPrice("250");
        pojoRequest.setDescription("Best Laptop");
        pojoRequest.setCategory("electronic");

// way 1
        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(pojoRequest);

        Response response = requestSpec.post();
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void addProductusingExternalJsonFile() {
        File requestJSONFile = new File("./product.json");

        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.body(requestJSONFile);

        Response response = requestSpec.post();
        System.out.println(response.getBody().asPrettyString());
    }
}
