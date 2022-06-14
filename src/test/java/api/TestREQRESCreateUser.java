package api;

import api.pojo_response_payloads.create_user.User;
import api.pojo_request_payloads.reqres.CreateUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestREQRESCreateUser {
    private static final CreateUser createUser = new CreateUser();
    private static User user = new User();

    private static Response response;

    @BeforeMethod
    public Response sendRequest() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";
        createUser.setName("Ahmed Madyan");
        createUser.setJob("Senior Test Automation Engineer");
        response = RestAssured.
                given().log().all().
                body(createUser).
                when().
                post().
                then().extract().response();
        user = response.as(User.class);
        System.out.println(response.then().extract().body().asPrettyString());
        return response;
    }

    @Test
    public static void assertResponseCode() {
        response.then().statusCode(HttpStatus.SC_CREATED);
        Assert.assertFalse(user.getCreatedAt().isEmpty());
    }

}
