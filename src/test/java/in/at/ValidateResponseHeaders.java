package in.at;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseHeaders {
    //    Date --> Sat, 11 Jul 2026 18:54:28 GMT
//    Content-Type --> application/json; charset=utf-8
//    Transfer-Encoding --> chunked
//    Connection --> keep-alive
//    Access-Control-Allow-Origin --> *
//    Etag --> W/"16d-ryVvNeDR+OwaJd+i2vi/OPo/G4Y"
//    X-Powered-By --> Express
//    Cf-Cache-Status --> DYNAMIC
//    Report-To --> {"group":"cf-nel","max_age":604800,"endpoints":[{"url":"https://a.nel.cloudflare.com/report/v4?s=hOldbIkv8kHcwDt9iJdM2e6Vvz4WNLFQwWV7meTYqKC3Y1zKiC%2BCHjO5d%2FgBj9Q%2FMG18Mcd5ddqz2fX2XDYJ2cKn4RiddoVuoSoLaZroxRhH1bNsd0nW0uUZpfpOzqmoX678"}]}
//    Nel --> {"report_to":"cf-nel","success_fraction":0.0,"max_age":604800}
//    Content-Encoding --> gzip
//    Server --> cloudflare
//    CF-RAY --> a19a04527bb2df34-LHR
//    alt-svc --> h3=":443"; ma=86400
    @Test
    public void printAllHeaders() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        Headers headers = response.headers();
        for (Header header : headers) {
            System.out.println(header.getName() + " --> " + header.getValue());
        }
    }

    @Test
    public void getSpecificHeader() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        System.out.println(response.getHeader("content-Type"));
    }

    @Test
    public void validateResponseHeaders() {
        RestAssured.baseURI = "https://fakestoreapi.com/products/1";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get();

        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }
}
