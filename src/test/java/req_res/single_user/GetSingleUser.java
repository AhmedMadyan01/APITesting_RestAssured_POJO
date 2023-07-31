//package req_res.single_user;
//
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.testng.annotations.Test;
//import utilities.api_driver.RequestBuilder;
//import utilities.api_driver.RequestMethod;
//
//public class GetSingleUser {
//    String baseURI = ("https://reqres.in/");
//    String baseBath = ("/api/users/2");
//
//    SingleUserPOJO singleUserPOJO = new SingleUserPOJO();
//
//    @Test
//    public void invokeGetSingleUserWithValidRequest() {
//        Response response = RequestBuilder.performRequest(baseURI, null, baseBath, null, RequestMethod.GET, null, null, null, null, HttpStatus.SC_OK, false);
//        singleUserPOJO = response.as(SingleUserPOJO.class);
////        System.out.println(singleUserPOJO.getData().getEmail());
//        System.out.println(response.asPrettyString());
//        System.out.println(response.jsonPath().get("data.email").toString());
//    }
//}
