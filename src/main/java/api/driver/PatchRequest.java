package api.driver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest extends SendRequest {
    @Override
    Response sendRequest(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).patch().then().extract().response();
    }

    @Override
    Response sendRequest(RequestSpecification requestSpecification, Integer httpStatus) {
        return RestAssured.given().spec(requestSpecification).patch().then().statusCode(httpStatus).extract().response();
    }
}
