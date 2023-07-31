//package tests;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import tests.pojo_request_payload.firebase.AuthenticatedToken;
//import utilities.api_driver.RequestBuilder;
//import utilities.api_driver.RequestMethod;
//
//import utilities.reader_manager.properties_reader.ConfigUtils;
//
//import java.util.HashMap;
//
//public class PostAuthenticatedToken {
//  static   String baseURI = ("https://www.googleapis.com/identitytoolkit");
//    private static final String endpoint = ("/v3/relyingparty/verifyPassword");
//    private static final HashMap<String, String> queryParametersMap = new HashMap<>();
//
//    static AuthenticatedToken authenticatedToken = new AuthenticatedToken();
//
//    @Test
//    public static void invokeFireBaseIdentityProviderEndpointWithValidKey() {
//        authenticatedToken.setEmail("tester55@toziapp.com");
//        authenticatedToken.setPassword("111111");
//        authenticatedToken.setReturnSecureToken(true);
//
//        queryParametersMap.put("key", "AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
//
//        Response response = RequestBuilder.performRequest(baseURI, null, endpoint, authenticatedToken, RequestMethod.POST,
//                null, null, queryParametersMap, null, HttpStatus.SC_OK, false, ContentType.JSON);
//
//        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
//        System.out.println(response.asString());
//        System.out.println(response.jsonPath().get("idToken").toString());
//
//    }
//}