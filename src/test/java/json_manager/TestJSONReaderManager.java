package json_manager;

import utilities.reader_manager.json_reader.JSONReaderManager;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestJSONReaderManager {
    @Test
    public void testJsonManager() throws IOException, ParseException {
        System.out.println(JSONReaderManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONReaderManager.Types.STRING).toString());
        System.out.println(JSONReaderManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONReaderManager.Types.LIST));
        List<Map<?,?>> users = (List<Map<?,?>>) JSONReaderManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.data", JSONReaderManager.Types.LIST);
        System.out.println(users.get(0).get("id"));
        Map<?, ?> totalPage = (Map<?, ?>) JSONReaderManager.getJSONData("src/test/resources/expected_response_payload/getListOfUsersREQRES.json", "getListOfUsersREQRES.support", JSONReaderManager.Types.MAP);
        System.out.println(totalPage.get("url"));
    }
}