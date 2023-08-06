package trials;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SingleUser {


    String baseURI = ("https://reqres.in");
    String basePath = ("/api/users/2");

    @Test
    public void sendReq() {
        User user;
        Response response = RestAssured.given().baseUri(baseURI).basePath(basePath).get().then().extract().response();
        user = response.as(User.class);
        System.out.println(user.getData().getFirst_name());
        System.out.println(response.getBody().asPrettyString());
    }
}
