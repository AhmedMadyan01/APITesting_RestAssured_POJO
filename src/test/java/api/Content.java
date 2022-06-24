package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Content {
    @Test
    public void invokeContentEndpoint() {
        Response response = RestAssured.given().get("https://wj0ek.mocklab.io/content-management-api/v1/content").then().extract().response();
        System.out.println(response.getBody().asPrettyString());
    }
}
