package get_list_users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetListUsers {
    String baseURI = ("https://reqres.in");
    String basePath = ("/api/users/2");

    @Test
    public void sendRequest() {
        User user ;
        Response response = RestAssured.given().baseUri(baseURI).basePath(basePath).get().then().extract().response();
        user = response.as(User.class);


        System.out.println("trials.User id:" + user.getData().getId());
        System.out.println(response.asPrettyString());
    }
}
