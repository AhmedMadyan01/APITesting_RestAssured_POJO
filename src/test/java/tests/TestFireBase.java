package tests;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import tests.pojo_response_payload.all_courses.AllCourses;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;

import java.util.*;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class TestFireBase {
    @Test
    public void fireBase() {
        Response response;
        List<Map<String, String>> query_Param = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("key", "AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
        query_Param.add(map);
        response = RequestBuilder.performRequest("https://identitytoolkit.googleapis.com", null, "/v1/accounts:signUp", null, RequestMethod.POST,
                null, query_Param, null, ContentType.JSON, HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.then().extract().body().asPrettyString());
    }
}