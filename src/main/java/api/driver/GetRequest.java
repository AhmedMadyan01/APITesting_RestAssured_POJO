package api.driver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class GetRequest extends SendRequest {
    @Override
    Response sendRequest(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).get().then().extract().response();
    }

    @Override
    Response sendRequest(RequestSpecification requestSpecification, Integer httpStatus) {
        return RestAssured.given().spec(requestSpecification).get().then().statusCode(httpStatus).extract().response();
    }
}
