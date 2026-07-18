package in.at;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Main {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://fakestoreapi.com/products";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();
        System.out.println(response.prettyPrint());

        //Alternatively
//        RestAssured.baseURI = "https://fakestoreapi.com/products";
//        RequestSpecification reqSpec = RestAssured.given();
//        Response response = reqSpec.request(Method.GET);
//        System.out.println(response.prettyPrint());
    }
}
