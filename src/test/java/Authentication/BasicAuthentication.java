package Authentication;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthentication {
    @Test
    public void performBasicAuthentication() {
        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.auth().basic("postman", "password");
        Response response = requestSpecification.get();

        System.out.println(response.getBody().asPrettyString());


        JsonPath jsonPath = response.jsonPath();
        boolean authenticated = jsonPath.getBoolean("authenticated");

        Assert.assertTrue(authenticated);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
