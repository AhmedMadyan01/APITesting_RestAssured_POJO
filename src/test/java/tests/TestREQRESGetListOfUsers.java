package tests;

import tests.pojo_response_payload.users_reqres.GetUsers;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;
import utilities.reader_manager.json_reader.JSONDataManager;
import utilities.reader_manager.properties_reader.ConfigUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestREQRESGetListOfUsers {
    private static GetUsers users = new GetUsers();
    @BeforeMethod
    public void sendRequest() {
        users = RequestBuilder.performRequest(ConfigUtils.getRequires_BaseURI(), null, ConfigUtils.getRequires_BasePath(), null, RequestMethod.GET, null, null, null, ContentType.JSON, HttpStatus.SC_OK).as(GetUsers.class);
    }

    @Test
    public void assertNumberOfUsers() throws IOException, ParseException {
        List<?> expectedUsersData = (List<?>) JSONDataManager.getJSONData("src/test/resources/expected_response_payload/GetListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONDataManager.Types.LIST);
        Assert.assertEquals(getNumberOfUsers(), expectedUsersData.size());
    }

    @Test
    public void assertOnResponseRootKeyValues() throws IOException, ParseException {
        Assert.assertEquals(users.getData().get(2).getFirst_name(), "Emma");
        Assert.assertEquals(users.getPage(), 1);
        Assert.assertEquals(users.getPer_page(), 6);
        Assert.assertEquals(users.getTotal(), 12);
        Assert.assertEquals(users.getTotal_pages(), 2);
    }

    @Test
    public void assertAllUserDataObjects() throws IOException, ParseException {
        List<?> expectedUsersData = (List<?>) JSONDataManager.getJSONData("src/test/resources/expected_response_payload/GetListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONDataManager.Types.LIST);
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