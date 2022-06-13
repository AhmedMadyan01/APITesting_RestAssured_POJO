package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGoogleMapsAddPlace {
    private static Response response;

    @BeforeMethod
    public Response sendRequest() {
        RestAssured.baseURI = "https://courses.rahulshettyacademy.com";
        RestAssured.basePath = "/maps/api/place/add/json";
        response = RestAssured.
                given().
                queryParam("key", "qaclick123").
                body(new Object()).
                when().
                post(RestAssured.basePath).
                then().extract().response();
        System.out.println(response.then().extract().body());
        return response;
    }

    @Test
    public static void assertResponseCode() {
        response.then().statusCode(HttpStatus.SC_OK);
    }
}
