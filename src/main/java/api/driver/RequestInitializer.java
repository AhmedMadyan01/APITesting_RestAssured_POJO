package api.driver;

import exceptions.ExceptionHandling;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class RequestInitializer {
    private String URI = null;
    private URL url = null;
    private Integer portNumber = null;
    private String path = null;
    private RequestMethod method = null;
    private Object requestBody = null;
    private Map<String, String> headers = null;
    private Map<String, String> pathParams = null;
    private Map<String, String> queryParams = null;
    private Map<String, String> formParams = null;
    private ContentType type = null;
    private Boolean urlEncoding = false;
    private Integer httpStatus = null;
    private RestAssuredConfig restAssuredConfig = null;

    public RequestInitializer setRequestMethod(@Nonnull RequestMethod requestMethod) {
        setMethod(requestMethod);
        return this;
    }

    public RequestInitializer setBaseUri(@Nonnull String uri) {
        setURI(uri);
        return this;
    }

    public RequestInitializer setBaseUri(@Nonnull URL uri) {
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public RequestInitializer setBasePath(@Nonnull String path) {
        setPath(path);
        return this;
    }

    public RequestInitializer setPort(@Nullable Integer port) {
        setPortNumber(port);
        return this;
    }

    public RequestInitializer setPort(@Nullable String port) {
        setPortNumber(Integer.parseInt(Objects.requireNonNull(port)));
        return this;
    }

    public RequestInitializer addHeaders(@Nullable Map<String, String> headers) {
        setHeaders(headers);
        return this;
    }

    public RequestInitializer addPathParams(@Nullable Map<String, String> pathParams) {
        setPathParams(pathParams);
        return this;
    }

    public RequestInitializer addQueryParams(@Nullable Map<String, String> queryParams) {
        setQueryParams(queryParams);
        return this;
    }

    public RequestInitializer addFormParams(@Nullable Map<String, String> formParams) {
        setFormParams(formParams);
        return this;
    }

    public RequestInitializer setBody(@Nullable Object requestBody) {
        setRequestBody(requestBody);
        return this;
    }

    public RequestInitializer setExpectedStatusCode(@Nullable Integer httpStatus) {
        setHttpStatus(httpStatus);
        return this;
    }

    public RequestInitializer setConfig(@Nullable RestAssuredConfig restAssuredConfig) {
        setRestAssuredConfig(restAssuredConfig);
        return this;
    }

    public RequestInitializer setContentType(@Nullable ContentType contentType) {
        setType(contentType);
        return this;
    }

    public RequestInitializer setUrlEncodingEnabled(@Nullable Boolean urlEncodingEnabled) {
        setUrlEncoding(urlEncodingEnabled);
        return this;
    }

    public Response sendRequest() {
        return send();
    }

    /**
     * Build API Request Specification
     */
    private RequestSpecification buildRequest() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        try {
            if (getURI() != null) {
                requestSpecBuilder.setBaseUri(getURI());
            } else {
                requestSpecBuilder.setBaseUri(getUrl().toURI());
            }
            requestSpecBuilder.setBasePath(getPath());
            if (getPortNumber() != null) {
                requestSpecBuilder.setPort(getPortNumber());
            }
            if (type != null) {
                requestSpecBuilder.setContentType(getType());
            }
            if (headers != null && !headers.isEmpty()) {
                requestSpecBuilder.addHeaders(getHeaders());
            }
            if (pathParams != null && !pathParams.isEmpty()) {
                requestSpecBuilder.addPathParams(getPathParams());
            }
            if (queryParams != null && !queryParams.isEmpty()) {
                requestSpecBuilder.addQueryParams(queryParams);
            }
            if (formParams != null && !formParams.isEmpty()) {
                requestSpecBuilder.addFormParams(formParams);
            }
            if (requestBody != null) {
                requestSpecBuilder.setBody(requestBody);
            }
            requestSpecBuilder.setRelaxedHTTPSValidation();
            requestSpecBuilder.setConfig(getRestAssuredConfig());
            requestSpecBuilder.setUrlEncodingEnabled(getUrlEncoding());
            System.out.println("=============================================================================================================================================");
            requestSpecBuilder.log(LogDetail.ALL);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return requestSpecBuilder.build();
    }

    /**
     * Perform API Request
     */
    private Response send() {
        Response response = null;
        try {
            given().relaxedHTTPSValidation();
            System.out.println("=============================================================================================================================================");
            if (getURI() != null) {
                System.out.println("Printing out all request specification details log for {Service URL: " + getURI() + getPath() + "}");
            } else {
                System.out.println("Printing out all request specification details log for {Service URL: " + getUrl() + getPath() + "}");
            }
            if (getHttpStatus() != null) {
                switch (method) {
                    case GET ->
                            response = given().spec(buildRequest()).get().then().log().all().statusCode(getHttpStatus()).extract().response();
                    case POST ->
                            response = given().spec(buildRequest()).post().then().log().all().statusCode(getHttpStatus()).extract().response();
                    case PUT ->
                            response = given().spec(buildRequest()).put().then().log().all().statusCode(getHttpStatus()).extract().response();
                    case DELETE ->
                            response = given().spec(buildRequest()).delete().then().log().all().statusCode(getHttpStatus()).extract().response();
                    case PATCH ->
                            response = given().spec(buildRequest()).patch().then().log().all().statusCode(getHttpStatus()).extract().response();
                    default -> System.out.println("Kindly select valid HTTP request method");
                }
            } else {
                switch (method) {
                    case GET -> response = given().spec(buildRequest()).get().then().log().all().extract().response();
                    case POST -> response = given().spec(buildRequest()).post().then().log().all().extract().response();
                    case PUT -> response = given().spec(buildRequest()).put().then().log().all().extract().response();
                    case DELETE ->
                            response = given().spec(buildRequest()).delete().then().log().all().extract().response();
                    case PATCH ->
                            response = given().spec(buildRequest()).patch().then().log().all().extract().response();
                    default -> System.out.println("Kindly select valid HTTP request method");
                }
            }
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
        System.out.println("=============================================================================================================================================");
        if (getURI() != null) {
            System.out.println("All request specification details log have been logged for {Service URL: " + getURI() + getPath() + "}");
        } else {
            System.out.println("All request specification details log have been logged for {Service URL: " + getUrl() + getPath() + "}");
        }
        System.out.println("=============================================================================================================================================");
        return response;
    }
}