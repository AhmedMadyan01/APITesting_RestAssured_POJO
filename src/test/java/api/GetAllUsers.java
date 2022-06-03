package api;

import api.POJOResponsePayloads.Users.GetUsers;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUsers {
    @Test
    public void getNumberOfCourses() {
        GetUsers getUsers =
                RestAssured.given().when().get("https://reqres.in/api/users?page=2").as(GetUsers.class);
        Assert.assertEquals(getUsers.getData().size(), 6);
        Assert.assertEquals(getUsers.getData().get(2).getFirst_name(), "Tobias");
        System.out.println(getUsers.getData().size());
    }
}
