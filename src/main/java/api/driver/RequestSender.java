package api.driver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class RequestSender {
    abstract Response send(RequestSpecification requestSpecification);

    abstract Response send(RequestSpecification requestSpecification, Integer httpStatus);

}
