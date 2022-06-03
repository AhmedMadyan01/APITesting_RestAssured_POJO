package api;

import api.POJOResponsePayloads.GetListOfUsersREQRES.GetUsers;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import netscape.javascript.JSObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileReader;

public class TestREQRESGetListOfUsers {
    Gson gson = new Gson();

//`    JSObject listOfUsersExpectedResponse= JSObject
    private static GetUsers users = new GetUsers();
    private static final String requestURL_GetUsersEndpoint = ("https://reqres.in/api/users?page=2");

    @BeforeClass
    public void sendRequest() {
        users = RestAssured.given().when().get(requestURL_GetUsersEndpoint).as(GetUsers.class);
    }

    @Test
    public void getNoOfUsers() {
        Assert.assertEquals(users.getData().size(), 6);
        System.out.println("No. of users:" + users.getData().size());
    }

    @Test
    public void getUsersFirstName() {
        // Extract users first name using for loop
        for (int i = 0; i < users.getData().size(); i++) {
            System.out.println("User " + (i + 1) + " First Name: " + users.getData().get(i).getFirst_name());
        }

        // Extract users first name using foreach
        users.getData().forEach(user -> System.out.println("User ID\t" + ((int) (user.getId())) + "\tfirst name is:\t" + user.getFirst_name()));
    }

    @Test
    public void getUserEmailForUserIDNoTen() {
        for (int i = 0; i < users.getData().size(); i++) {
            if (users.getData().get(i).getId() == 10) {
                System.out.println("User ID\t" + ((int) (users.getData().get(i).getId())) + "\temail is:\t" + users.getData().get(i).getEmail());
            }
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

    @Test
    public void assertOnWholeUsersData() {
        gson.newJsonReader()
    }
}