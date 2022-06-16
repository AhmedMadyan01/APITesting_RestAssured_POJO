package json_manager;

import utilities.JSONManager;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJSONManager {
    @Test
    public void testJsonManager() throws IOException, ParseException {
        System.out.println(JSONManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.STRING).toString());
        System.out.println(JSONManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.LIST));
        List<Map<?,?>> users = (List<Map<?,?>>) JSONManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONManager.Types.LIST);
        System.out.println(users.get(0).get("id"));
        Map<?, ?> totalPage = (Map<?, ?>) JSONManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.support", JSONManager.Types.MAP);
        System.out.println(totalPage.get("url"));
    }
}