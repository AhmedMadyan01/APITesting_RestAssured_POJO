package api;

import utilities.JSONManager;
import api.pojoResponsePayloads.GetListOfUsersREQRES.GetUsers;
import io.restassured.RestAssured;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestREQRESGetListOfUsers {
    private static GetUsers users = new GetUsers();
    private static final String requestURL_GetUsersEndpoint = ("https://reqres.in/api/users?page=2");

    @BeforeClass
    public void sendRequest() {
        users = RestAssured.given().when().get(requestURL_GetUsersEndpoint).as(GetUsers.class);
    }

    @Test
    public void assertNumberOfUsers() throws IOException, ParseException {
        List<?> expectedUsersData = (List<?>) JSONManager.getJSONData("src/test/resources/ExpectedResponsePayloads/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.LIST);
        Assert.assertEquals(getNumberOfUsers(), expectedUsersData.size());
    }

    @Test
    public void assertOnResponseRootKeyValues() throws IOException, ParseException {
        List<?> expectedData = (List<?>) JSONManager.getJSONData("src/test/resources/ExpectedResponsePayloads/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.LIST);
        Assert.assertEquals(users.getData().get(2).getFirst_name(), "Tobias");
        Assert.assertEquals(users.getPage(), 2);
        Assert.assertEquals(users.getPer_page(), 6);
        Assert.assertEquals(users.getTotal(), 12);
        Assert.assertEquals(users.getTotal_pages(), 2);
    }

    @Test
    public void assertAllUserDataObjects() throws IOException, ParseException {
        List<?> expectedUsersData = (List<?>) JSONManager.getJSONData("src/test/resources/ExpectedResponsePayloads/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.LIST);
        for (int i = 0; i < users.getData().size(); i++) {
            // Retrieve expected data
            HashMap<?, ?> expectedUsersIDs = (HashMap<?, ?>) expectedUsersData.get(i);
            HashMap<?, ?> expectedUsersEmails = (HashMap<?, ?>) expectedUsersData.get(i);
            HashMap<?, ?> expectedFirstNames = (HashMap<?, ?>) expectedUsersData.get(i);
            HashMap<?, ?> expectedLastNames = (HashMap<?, ?>) expectedUsersData.get(i);
            HashMap<?, ?> expectedAvatars = (HashMap<?, ?>) expectedUsersData.get(i);
            // Assertion for all users
            Assert.assertEquals(expectedUsersIDs.get("id"), (int) (users.getData().get(i).getId()));
            Assert.assertEquals(expectedUsersEmails.get("email"), (users.getData().get(i).getEmail()));
            Assert.assertEquals(expectedFirstNames.get("first_name"), (users.getData().get(i).getFirst_name()));
            Assert.assertEquals(expectedLastNames.get("last_name"), (users.getData().get(i).getLast_name()));
            Assert.assertEquals(expectedAvatars.get("avatar"), (users.getData().get(i).getAvatar()));
        }
    }

    public int getNumberOfUsers() {
        System.out.println("No. of users:" + users.getData().size());
        return users.getData().size();
    }

    public void getUsersFirstName() {
        // Extract users first name using for loop
        for (int i = 0; i < users.getData().size(); i++) {
            System.out.println("User " + (i + 1) + " First Name: " + users.getData().get(i).getFirst_name());
        }

        // Extract users first name using foreach
        users.getData().forEach(user -> System.out.println("User ID\t" + ((int) (user.getId())) + "\tfirst name is:\t" + user.getFirst_name()));
    }

    public void getUserEmailForUserIDNoTen() {
        for (int i = 0; i < users.getData().size(); i++) {
            if (users.getData().get(i).getId() == 10) {
                System.out.println("User ID\t" + ((int) (users.getData().get(i).getId())) + "\temail is:\t" + users.getData().get(i).getEmail());
            }
        }
    }
}