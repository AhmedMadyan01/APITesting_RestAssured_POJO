package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class RequestBuilder {
    private RequestSpecification requestSpecification;

    public static RequestSpecification buildRequest
            (String baseUri, String port, String basePath, List<Map<String, Object>> headers, List<Map<String, Object>> queryParam, List<Map<String, Object>> formParam, ContentType contentType) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUri);
        requestSpecBuilder.setBasePath(basePath);
        if (port != null) {
            requestSpecBuilder.setPort(Integer.parseInt(port));
        }
        if (contentType != null) {
            requestSpecBuilder.setContentType(contentType);
        }

        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }

}
