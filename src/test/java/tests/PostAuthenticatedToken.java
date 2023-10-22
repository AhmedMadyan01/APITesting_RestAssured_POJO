//package tests;
//
//import api.driver.RequestMethod;
//import api.pojo.requests.firebase.AuthenticatedToken_Req;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//
//public class PostAuthenticatedToken {
//    static String baseURI = ("https://www.googleapis.com/identitytoolkit");
//    private static final String endpoint = ("/v3/relyingparty/verifyPassword");
//    private static final HashMap<String, String> queryParametersMap = new HashMap<>();
//    static AuthenticatedToken_Req authenticatedToken = new AuthenticatedToken_Req();
//    @Test
//    public static void invokeFireBaseIdentityProviderEndpointWithValidKey() {
//        authenticatedToken.setEmail("tester55@toziapp.com");
//        authenticatedToken.setPassword("111111");
//        authenticatedToken.setReturnSecureToken(true);
//        queryParametersMap.put("key", "AIzaSyAKKukGTd6HJmyTsj-phKADa9uGNVKOQlY");
////        Response response = RequestBuilder.performRequest(baseURI, null, endpoint, authenticatedToken, RequestMethod.POST,
////                null, null, queryParametersMap, null, HttpStatus.SC_OK, false, ContentType.JSON);
//
//        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
//        System.out.println(response.asString());
//        System.out.println(response.jsonPath().get("idToken").toString());
//    }
//}