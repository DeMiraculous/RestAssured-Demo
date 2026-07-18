package in.at;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidateResponseStatusCode {
    public void validateSuccessResponseCode() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        int statusCode = response.getStatusCode();
        System.out.println("status code --> " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
