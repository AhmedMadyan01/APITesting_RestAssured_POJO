package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFireBase {
    @Test
    public void fireBase() {
        Response response;
        Map<String, String> map = new HashMap<>();
        map.put("key", "AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
        response = RequestBuilder.performRequest("https://identitytoolkit.googleapis.com", null, "/v1/accounts:signUp", null, RequestMethod.POST,
                null, map, null, HttpStatus.SC_OK, false, ContentType.JSON);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.then().extract().body().asPrettyString());
    }
}