package api;

import api.POJORequestPayloads.CreateUsers;
import api.POJOResponsePayloads.CreateUser.User;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserDataEqualsCreatedUserData {
    @Test
    public void createUser() {
        CreateUsers createUser = new CreateUsers();
        createUser.setName("Ahmed");
        createUser.setJob("Software Test Automation Engineer");
        User user = RestAssured.given().when().post("https://reqres.in/api/users").body(createUser).as(User.class);
    }
}
