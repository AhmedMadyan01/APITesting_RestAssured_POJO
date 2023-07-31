//package req_res.list_of_users;
//
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.testng.annotations.Test;
//import req_res.single_user.SingleUserPOJO;
//import utilities.api_driver.RequestBuilder;
//import utilities.api_driver.RequestMethod;
//
//public class TestListUsers {
//
//    String baseURI = ("https://reqres.in/");
//    String baseBath = ("/api/users?page=2");
//
//    ListUsers listUsersPOJO = new ListUsers();
//
//    @Test
//    public void invokeGetSingleUserWithValidRequest() {
//        Response response = RequestBuilder.performRequest(baseURI, null, baseBath, null, RequestMethod.GET, null, null, null, null, HttpStatus.SC_OK, false);
//        listUsersPOJO = response.as(ListUsers.class);
//        System.out.println(response.asPrettyString());
//        System.out.println(listUsersPOJO.getData().get(1).getFirst_name());
//       // System.out.println(response.asPrettyString());
//        //System.out.println(response.jsonPath().get("data.email").toString());
//    }
//}
