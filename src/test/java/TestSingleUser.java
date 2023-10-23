import api.driver.APIActions;
import api.driver.RequestMethod;
import assertions.Assertions;
import assertions.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class TestSingleUser {
    static String baseURI = "https://reqres.in";
    static String basePath = "/api/user";
    static Response response;

    @Test
    public void sendRequest() {
        HashMap<String, String> query = new HashMap<>();
        query.put("page", "2");
        response = APIActions.setRequestSpecifications().setRequestMethod(RequestMethod.GET).setBaseUri(baseURI).setBasePath(basePath).addQueryParams(query).sendRequest();
        List<Integer> ids = response.getBody().jsonPath().getList("data.id");
        System.out.println(ids.get(2));
        Assertions.hardAssert().objectEquals(ids.get(2), 9);
    }

    @Test(dependsOnMethods = "sendRequest")
    public void assertStatusCode() {
        Assertions.hardAssert().responseStatusCodeEquals(response, StatusCode.SC_OK);
    }
}
