package api.driver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class SendRequest {
    abstract Response sendRequest(RequestSpecification requestSpecification);

    abstract Response sendRequest(RequestSpecification requestSpecification, Integer httpStatus);

}
