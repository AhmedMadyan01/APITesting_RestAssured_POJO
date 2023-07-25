package utilities.api_driver;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    private static RequestSpecification buildRequest
            (String baseUri, String port, String basePath, Object requestBody, Map<String, String> headers, Map<String, String> queryParam, Map<String, String> formParam, ContentType contentType, boolean urlEncodingEnabled) {
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
            requestSpecBuilder.addHeaders(headers);
        }
        if (queryParam != null && !queryParam.isEmpty()) {
            requestSpecBuilder.addQueryParams(queryParam);

        }
        if (formParam != null && !formParam.isEmpty()) {
            requestSpecBuilder.addFormParams(formParam);
        }
        if (requestBody != null) {
            requestSpecBuilder.setBody(requestBody);
        }
        requestSpecBuilder.setUrlEncodingEnabled(urlEncodingEnabled);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        return requestSpecBuilder.build();
    }

    /**
     * Perform API request
     */
    public static Response performRequest
    (String baseUri, String port, String basePath, Object requestBody, RequestMethod requestMethod, Map<String, String> headers, Map<String, String> queryParam, Map<String, String> formParam, int expectedStatusCode, boolean urlEncodingEnabled, ContentType contentType) {
        Response response = null;
        given().relaxedHTTPSValidation();
        System.out.println("Printing out request logs:");
        switch (requestMethod) {
            case GET ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType, urlEncodingEnabled)).get().then().statusCode(expectedStatusCode).extract().response();
            case POST ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType, urlEncodingEnabled)).post().then().statusCode(expectedStatusCode).extract().response();
            case PUT ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType, urlEncodingEnabled)).put().then().statusCode(expectedStatusCode).extract().response();
            case DELETE ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType, urlEncodingEnabled)).delete().then().statusCode(expectedStatusCode).extract().response();
            case PATCH ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, contentType, urlEncodingEnabled)).patch().then().statusCode(expectedStatusCode).extract().response();
            default -> System.out.println("Kindly select valid HTTP request method");
        }
        System.out.println("All request logs have been logged.\n");
        return response;
    }

    /**
     * Perform request without content type
     */
    public static Response performRequest
    (String baseUri, String port, String basePath, Object requestBody, RequestMethod requestMethod, Map<String, String> headers, Map<String, String> queryParam, Map<String, String> formParam, int expectedStatusCode, boolean urlEncodingEnabled) {
        Response response = null;
        given().relaxedHTTPSValidation();
        System.out.println("Printing out request logs:");
        switch (requestMethod) {
            case GET ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null, urlEncodingEnabled)).get().then().statusCode(expectedStatusCode).extract().response();
            case POST ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null, urlEncodingEnabled)).post().then().statusCode(expectedStatusCode).extract().response();
            case PUT ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null, urlEncodingEnabled)).put().then().statusCode(expectedStatusCode).extract().response();
            case DELETE ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null, urlEncodingEnabled)).delete().then().statusCode(expectedStatusCode).extract().response();
            case PATCH ->
                    response = given().spec(buildRequest(baseUri, port, basePath, requestBody, headers, queryParam, formParam, null, urlEncodingEnabled)).patch().then().statusCode(expectedStatusCode).extract().response();
            default -> System.out.println("Kindly select valid HTTP request method");
        }
        System.out.println("All request logs have been logged.\n");
        return response;
    }
}