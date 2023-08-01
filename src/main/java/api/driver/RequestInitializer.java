package api.driver;

import exceptions.ExceptionHandling;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class RequestInitializer {
    private String uri = null;
    private URL url = null;
    private Integer port = null;
    private String basePath = null;
    private RequestMethod requestMethod = null;
    private Object requestBody = null;
    private Map<String, String> headers = null;
    private Map<String, String> pathParams = null;
    private Map<String, String> queryParams = null;
    private Map<String, String> formParams = null;
    private ContentType contentType = null;
    private Boolean urlEncodingEnabled = false;
    private Integer httpStatusCode = null;
    private RestAssuredConfig restAssuredConfig = null;

    public RequestInitializer setRequestMethod(@Nonnull RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public RequestInitializer setBaseUri(@Nonnull String uri) {
        this.uri = uri;
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

    public RequestInitializer setBasePath(@Nonnull String basePath) {
        this.basePath = basePath;
        return this;
    }

    public RequestInitializer setPort(@Nullable Integer port) {
        this.port = port;
        return this;
    }

    public RequestInitializer setPort(@Nullable String port) {
        this.port = Integer.parseInt(Objects.requireNonNull(port));
        return this;
    }

    public RequestInitializer addHeaders(@Nullable Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RequestInitializer addPathParams(@Nullable Map<String, String> pathParams) {
        this.pathParams = pathParams;
        return this;
    }

    public RequestInitializer addQueryParams(@Nullable Map<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public RequestInitializer addFormParams(@Nullable Map<String, String> formParams) {
        this.formParams = formParams;
        return this;
    }

    public RequestInitializer setBody(@Nullable Object requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public RequestInitializer setExpectedStatusCode(@Nullable Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public RequestInitializer setConfig(@Nullable RestAssuredConfig restAssuredConfig) {
        this.restAssuredConfig = restAssuredConfig;
        return this;
    }

    public RequestInitializer setContentType(@Nullable ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public RequestInitializer setUrlEncodingEnabled(@Nullable Boolean urlEncodingEnabled) {
        this.urlEncodingEnabled = urlEncodingEnabled;
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
            if (uri != null) {
                requestSpecBuilder.setBaseUri(uri);
            } else {
                requestSpecBuilder.setBaseUri(url.toURI());
            }
            requestSpecBuilder.setBasePath(basePath);
            if (port != null) {
                requestSpecBuilder.setPort(port);
            }
            if (contentType != null) {
                requestSpecBuilder.setContentType(contentType);
            }
            if (headers != null && !headers.isEmpty()) {
                requestSpecBuilder.addHeaders(headers);
            }
            if (pathParams != null && !pathParams.isEmpty()) {
                requestSpecBuilder.addPathParams(pathParams);
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
            requestSpecBuilder.setConfig(restAssuredConfig);
            requestSpecBuilder.setUrlEncodingEnabled(urlEncodingEnabled);
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
            if (uri != null) {
                System.out.println("Printing out all request specification details log for {Service URL: " + uri + basePath + "}");
            } else {
                System.out.println("Printing out all request specification details log for {Service URL: " + url + basePath + "}");
            }
            if (httpStatusCode != null) {
                switch (requestMethod) {
                    case GET ->
                            response = given().spec(buildRequest()).get().then().log().all().statusCode(httpStatusCode).extract().response();
                    case POST ->
                            response = given().spec(buildRequest()).post().then().log().all().statusCode(httpStatusCode).extract().response();
                    case PUT ->
                            response = given().spec(buildRequest()).put().then().log().all().statusCode(httpStatusCode).extract().response();
                    case DELETE ->
                            response = given().spec(buildRequest()).delete().then().log().all().statusCode(httpStatusCode).extract().response();
                    case PATCH ->
                            response = given().spec(buildRequest()).patch().then().log().all().statusCode(httpStatusCode).extract().response();
                    default -> System.out.println("Kindly select valid HTTP request method");
                }
            } else {
                switch (requestMethod) {
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
        if (uri != null) {
            System.out.println("All request specification details log have been logged for {Service URL: " + uri + basePath + "}");
        } else {
            System.out.println("All request specification details log have been logged for {Service URL: " + url + basePath + "}");
        }
        System.out.println("=============================================================================================================================================");
        return response;
    }
}