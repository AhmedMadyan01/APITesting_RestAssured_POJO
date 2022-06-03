package api;

import api.POJOResponsePayloads.GetListOfUsers.GetUsers;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestREQRESGetListOfUsers {
    private static GetUsers users = new GetUsers();

    @BeforeClass
    public void sendRequest() {
        users = RestAssured.given().when().get("https://reqres.in/api/users?page=2").as(GetUsers.class);
    }

    @Test
    public void getNoOfUsers() {
        Assert.assertEquals(users.getData().size(), 6);
        System.out.println("No. of users:" + users.getData().size());
    }

    @Test
    public void getUsersFirstName() {
        for (int i = 0; i <= users.getData().size() - 1; i++) {
            System.out.println("User " + (i + 1) + " First Name: " + users.getData().get(i).getFirst_name());
        }
    }

    @Test
    public void assertOnNumberOfUsers() {
        Assert.assertEquals(users.getData().size(), 6);
    }

    @Test
    public void assertOnResponseRootKeyValues() {
        Assert.assertEquals(users.getData().get(2).getFirst_name(), "Tobias");
        Assert.assertEquals(users.getPage(), 2);
        Assert.assertEquals(users.getPer_page(), 6);
        Assert.assertEquals(users.getTotal(), 12);
        Assert.assertEquals(users.getTotal_pages(), 2);
    }
}