package tests;

import tests.pojo_response_payload.all_courses.AllCourses;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;

public class TestGetAllCourses {

    @Test
    public void getNumberOfCourses() {
//        AllCourses allCourses =
//                RestAssured.given().expect().defaultParser(Parser.JSON).when().get("https://www.rahulshettyacademy.com/api/course").as(AllCourses.class);
        AllCourses allCourses =
                RequestBuilder.performRequest("https://www.rahulshettyacademy.com", null, "/tests/course", null, RequestMethod.GET, null, null, null, ContentType.JSON, HttpStatus.SC_OK, true).as(AllCourses.class);
        System.out.println(allCourses.getCourses());
    }
}
