package api;

import api.pojo_request_payloads.reqres.CreateUser;
import org.testng.annotations.Test;

public class TestUserDataEqualsCreatedUserData {
    @Test
    public void createUser() {
        CreateUser createUser = new CreateUser();
        createUser.setName("Ahmed");
        createUser.setJob("Software Test Automation Engineer");
//        User user = RestAssured.given().when().post("https://reqres.in/api/users").body().as(CreateUsers.class).(User.class);
    }
}
