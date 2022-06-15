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
        return requestSpecBuilder.build();
    }

}
