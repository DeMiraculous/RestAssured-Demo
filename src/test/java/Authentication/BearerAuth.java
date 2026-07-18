package Authentication;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class BearerAuth {
    public void getAllRepo() {
        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RestAssured.basePath= "/user/repos";

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get();
        requestSpecification.header("Authorization", "place an actual token");

        JsonPath jsonPath = response.jsonPath();
        String repoName = jsonPath.get("name");

        System.out.println(repoName);

        Assert.assertEquals(response.statusCode(), 200);


    }
}
