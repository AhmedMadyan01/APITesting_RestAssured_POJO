package api.driver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest extends RequestSender {
    @Override
    Response send(RequestSpecification requestSpecification) {
        return RestAssured.given().spec(requestSpecification).get().then().extract().response();
    }

    @Override
    Response send(RequestSpecification requestSpecification, Integer httpStatus) {
        return RestAssured.given().spec(requestSpecification).get().then().statusCode(httpStatus).extract().response();
    }
}
