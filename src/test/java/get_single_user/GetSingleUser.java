package get_single_user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetSingleUser {
    String baseURI = ("https://reqres.in");
    String basePath = ("/api/users");

    @Test
    public void sendRequest() {
        HashMap<String, String> query = new HashMap<>();
        query.put("page", "2");

        User user;
        Response response = RestAssured.given().baseUri(baseURI).basePath(basePath).queryParams(query).get().then().extract().response();


        System.out.println("trials.User id:" + response.getBody().jsonPath().get("data[0].first_name"));
        System.out.println(response.asPrettyString());
    }
}
