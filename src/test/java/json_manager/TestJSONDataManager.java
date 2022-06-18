package json_manager;

import utilities.reader_manager.json_reader.JSONDataManager;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestJSONDataManager {
    @Test
    public void testJsonManager() throws IOException, ParseException {
        System.out.println(JSONDataManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONDataManager.Types.STRING).toString());
        System.out.println(JSONDataManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONDataManager.Types.LIST));
        List<Map<?,?>> users = (List<Map<?,?>>) JSONDataManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONDataManager.Types.LIST);
        System.out.println(users.get(0).get("id"));
        Map<?, ?> totalPage = (Map<?, ?>) JSONDataManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.support", JSONDataManager.Types.MAP);
        System.out.println(totalPage.get("url"));
    }
}