package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.Authenticator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestBuilder {
    private static RequestSpecification buildRequest
            (String baseUri, String port, String basePath, List<Map<String, String>> headers, List<Map<String, String>> queryParam, List<Map<String, String>> formParam, ContentType contentType) {
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
                requestSpecBuilder.addHeaders(queryParam.get(i));
            }
        }

        if (formParam != null && !formParam.isEmpty()) {
            for (int i = 0; i <= formParam.size(); i++) {
                requestSpecBuilder.addHeaders(formParam.get(i));
            }
        }
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecBuilder.setRelaxedHTTPSValidation();
        return requestSpecBuilder.build();
    }

    public static Response invokeAPI(String baseUri, String port, String basePath, RequestType requestType, List<Map<String, String>> headers, List<Map<String, String>> queryParam, List<Map<String, String>> formParam, ContentType contentType) {
        Response response = null;
        given().relaxedHTTPSValidation();
        switch (requestType){
            case GET -> response = given().spec(buildRequest(baseUri,port,basePath,headers,queryParam,formParam,contentType)).get().then().extract().response();
            case POST -> response = given().spec(buildRequest(baseUri,port,basePath,headers,queryParam,formParam,contentType)).post().then().extract().response();
            case PUT -> response = given().spec(buildRequest(baseUri,port,basePath,headers,queryParam,formParam,contentType)).put().then().extract().response();
            case PATCH -> response = given().spec(buildRequest(baseUri,port,basePath,headers,queryParam,formParam,contentType)).patch().then().extract().response();
            case DELETE -> response = given().spec(buildRequest(baseUri,port,basePath,headers,queryParam,formParam,contentType)).delete().then().extract().response();
        }
        return response;
    }

    public enum RequestType {
        POST, GET, PATCH, DELETE, PUT
    }
}
