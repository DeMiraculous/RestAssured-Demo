package Authentication;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ApiKeyAuth {
    public void getWeatherInfo() {
        RestAssured.baseURI = "https://api.openweathermap.org";
        RestAssured.basePath = "/data/2.5.weather";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("q", "hyderabad");
        requestSpecification.queryParam("appId", "put a valid ApiKey");

        Response response = requestSpecification.get();
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
