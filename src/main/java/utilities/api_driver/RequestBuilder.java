package utilities.api_driver;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    private static RequestSpecification buildRequest
            (String baseUri, String port, String basePath, Object requestBody, List<Map<String, String>> headers, List<Map<String, String>> queryParam, List<Map<String, String>> formParam, ContentType contentType) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUri);
        requestSpecBuilder.setBasePath(basePath);
        if (port != null) {
            requestSpecBuilder.setPort(Integer.parseInt(port));
        }
        if (contentType != null) {
            requestSpecBuilder.setContentType(contentType);
        }
        if (headers != null && !headers.isEmpty()) {
            for (int i = 0; i <= headers.size(); i++) {
                requestSpecBuilder.addHeaders(headers.get(i));
            }
        }
        if (queryParam != null && !queryParam.isEmpty()) {
            for (int i = 0; i <= queryParam.size(); i++) {
                requestSpecBuilder.addQueryParams(queryParam.get(i));
            }
        }
        if (formParam != null && !formParam.isEmpty()) {
            for (int i = 0; i <= formParam.size(); i++) {
                requestSpecBuilder.addFormParams(formParam.get(i));
            }
        }
        if (requestBody != null) {
            requestSpecBuilder.setBody(requestBody);
        }
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        return requestSpecBuilder.build();
    }

    /**
     * Perform API request
     */
    public static Response performRequest
    (String baseUri, String port, String basePath, Object requestBody, RequestMethod requestMethod, List<Map<String, String>> headers, List<Map<String, String>> queryParam, List<Map<String, String>> formParam, ContentType contentType, int expectedStatusCode) {
        Response response = null;
        given().relaxedHTTPSValidation();
        System.out.println("Printing out request logs:");
        switch (requestMethod) {
            case GET ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType)).get().then().statusCode(expectedStatusCode).extract().response();
            case POST ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType)).post().then().statusCode(expectedStatusCode).extract().response();
            case PUT ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType)).put().then().statusCode(expectedStatusCode).extract().response();
            case DELETE ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType)).delete().then().statusCode(expectedStatusCode).extract().response();
            case PATCH ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType)).patch().then().statusCode(expectedStatusCode).extract().response();
            default -> System.out.println("Kindly select valid HTTP request method");
        }
        System.out.println("All request logs have been logged.\n");
        return response;
    }

    /**
     * Perform request without content type
     */
    public static Response performRequest
    (String baseUri, String port, String basePath, Object requestBody, RequestMethod requestMethod, List<Map<String, String>> headers, List<Map<String, String>> queryParam, List<Map<String, String>> formParam, int expectedStatusCode) {
        Response response = null;
        given().relaxedHTTPSValidation();
        System.out.println("Printing out request logs:");
        switch (requestMethod) {
            case GET ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null)).get().then().statusCode(expectedStatusCode).extract().response();
            case POST ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null)).post().then().statusCode(expectedStatusCode).extract().response();
            case PUT ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null)).put().then().statusCode(expectedStatusCode).extract().response();
            case DELETE ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null)).delete().then().statusCode(expectedStatusCode).extract().response();
            case PATCH ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null)).patch().then().statusCode(expectedStatusCode).extract().response();
            default -> System.out.println("Kindly select valid HTTP request method");
        }
        System.out.println("All request logs have been logged.\n");
        return response;
    }
}