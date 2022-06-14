package api;

import api.pojo_request_payload.google_maps.GoogleMapsAddPlace;
import api.pojo_request_payload.google_maps.Location;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGoogleMapsAddPlace {
    private static Response response;
    GoogleMapsAddPlace googleMapsAddPlace = new GoogleMapsAddPlace();
    Location location = new Location();

    @BeforeMethod
    public Response sendRequest() {
        List<String> types = new ArrayList<>();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        googleMapsAddPlace.setLocation(location);
        googleMapsAddPlace.setAccuracy(50);
        googleMapsAddPlace.setName("Frontline house");
        googleMapsAddPlace.setPhone_number("(+91) 983 893 3937");
        googleMapsAddPlace.setAddress("29, side layout, cohen 09");
        types.add("shoe park");
        types.add("shop");
        googleMapsAddPlace.setTypes(types);
        googleMapsAddPlace.setWebsite("https://www.google.com/");
        googleMapsAddPlace.setLanguage("French-IN");
        RestAssured.baseURI = "https://courses.rahulshettyacademy.com";
        RestAssured.basePath = "/maps/api/place/add/json";
        response = RestAssured.
                given().log().all().
                queryParam("key", "qaclick123").
                body(googleMapsAddPlace).
                when().
                post().
                then().extract().response();
        System.out.println(response.then().extract().body().asPrettyString());
        return response;
    }

    @Test
    public static void assertResponseCode() {
        response.then().statusCode(HttpStatus.SC_OK);
    }
}
