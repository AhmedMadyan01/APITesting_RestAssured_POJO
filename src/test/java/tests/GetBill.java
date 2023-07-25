package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class GetBill {
    String baseURI = ("https://api.non-prod.vf-itaap.engineering.vodafone.com");
    String endPoint = ("/bill-analysis-js/api/v1/bill");

    @Test
    public void sendRequest() {
        Map<String, String> query_map = new HashMap<>();
        query_map.put("billingAccount.id", "BI33445566");
        query_map.put("limit", "3");


        Map<String, String> headers_map = new HashMap<>();
        headers_map.put("vf-country-code", "IE");
        headers_map.put("vf-project", "ONEAPP");
        headers_map.put("Cookie", "{{Cookie}}");
        headers_map.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJsb2dpbl9oaW50IjoiMTg4MTAxMjciLCJleHAiOjE3MjA4Njg1NTUsImlhdCI6MTY4OTc2NDU1NSwianRpIjoiMWQ3NjQ3ZTUtNjdhYi00ZDFmLTliZjctMTYxOTk2Mjk0YzEwIiwic2NvcGUiOiJwaG9uZSBvcGVuaWQgZW1haWwgb2ZmbGluZV9hY2Nlc3MgcHJvZmlsZSJ9.h1Nv7uYHwrIsz8NBisP2wz7aVfzSEePgPNYlyEDZUCGgh_b46IASqtkvpce4O-kuIBi5g-8HP0cpqj06pixdovv4FC7um9m2BPEaNR54sNF71JXzAYMlTTTUCQIH3itTKaGYeksC6pOstUyaT6_w2PdFCuA0zauRitJVuTgfeLoij9saOYiXMPEfAjSGF3dVx6IKUuyOlnsD8orCXBYDXfjs86Is-XG9ZMIrjS1Yi27NXcnQWw2sZ7EKIoooPYajO-pMbg4Pin5n79Teu_svvvXytNX5Ae4V0-tCBEQHvarBi1zioxDPGBP5Ngbw352VC2WXnpd7usrH5Pvd1LgC9A");
        headers_map.put("CF-Access-Client-Secret", "6423bc67b7f9579917b01ba92590a7ffc2144800aff6e32864c5b2459c603b75");
        headers_map.put("CF-Access-Client-Id", "e022a18ccb80b93937a395cf7e539d24.access");


        Response response = RequestBuilder.performRequest(baseURI, "443", endPoint, null, RequestMethod.GET, headers_map, query_map, null, HttpStatus.SC_OK, false, ContentType.JSON);

        System.out.println(response.getBody());
    }
}