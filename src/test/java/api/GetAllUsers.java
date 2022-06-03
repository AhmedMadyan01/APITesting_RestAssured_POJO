package api;

import api.POJOResponsePayloads.Users.GetUsers;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class GetAllUsers {
    @Test
    public void getNoOfUsers() {
        GetUsers getUsers =
                RestAssured.given().when().get("https://reqres.in/api/users?page=2").as(GetUsers.class);
        Assert.assertEquals(getUsers.getData().size(), 6);
        System.out.println("No. of users:" + getUsers.getData().size());
    }

    @Test
    public void getUsersFirstName() {
        GetUsers getUsers =
                RestAssured.given().when().get("https://reqres.in/api/users?page=2").as(GetUsers.class);
        Assert.assertEquals(getUsers.getData().size(), 6);
        Assert.assertEquals(getUsers.getData().get(2).getFirst_name(), "Tobias");
        for (int i = 0; i <= getUsers.getData().size() - 1; i++) {
            System.out.println("User " + i + " First Name: " + getUsers.getData().get(i).getFirst_name());
        }
    }
}