package TestGetContent;

import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.responses.content.Content;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class TestGetContent {
    private static final HashMap<String, String> headersMap = new HashMap<>();
    private static String bearerToken = null;

    @BeforeTest
    public static void generateToken() {
        String baseURI = ("https://identitytoolkit.googleapis.com");
        String baseBath = ("/v1/accounts:signUp");
        HashMap<String, String> queryParametersMap = new HashMap<>();
        queryParametersMap.put("key", "AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
        Response response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.POST)
                .setBaseUri(baseURI)
                .setBasePath(baseBath)
                .addQueryParams(queryParametersMap)
                .sendRequest();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        bearerToken = response.jsonPath().get("idToken").toString();
        System.out.println(response.jsonPath().get("idToken").toString());
    }

    @Test
    public static void invokeContentEndpointWithValidRequest() {
        String baseURI = ("https://api.dev.to-zi.com");
        String baseBath = ("/content-management-api/content");
        headersMap.put("token", bearerToken);
        System.out.println(headersMap);
        Response response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.GET)
                .setBaseUri(baseURI)
                .setBasePath(baseBath)
                .addHeaders(headersMap)
                .sendRequest();

        System.out.println(response.asPrettyString());
        List<Content> contentList = response.as(new TypeRef<>() {
        });

        System.out.println(contentList.get(0).getContentId());
        System.out.println(contentList.get(0));
    }
}