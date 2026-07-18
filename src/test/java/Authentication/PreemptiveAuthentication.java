package Authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreemptiveAuthentication {
    public void preemptiveAuth() {
        RestAssured.baseURI = "https://postman-echo.com/basic-auth";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.auth().preemptive().basic("postman", "password");

        Response response = requestSpecification.get();
    }
}
