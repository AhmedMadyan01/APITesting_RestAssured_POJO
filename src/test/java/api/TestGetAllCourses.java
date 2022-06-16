package api;

import api.pojo_response_payload.all_courses.AllCourses;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;
import utilities.api_driver.RequestBuilder;
import utilities.api_driver.RequestMethod;

public class TestGetAllCourses {

    @Test
    public void getNumberOfCourses() {
//        AllCourses allCourses =
//                RestAssured.given().expect().defaultParser(Parser.JSON).when().get("https://www.rahulshettyacademy.com/api/course").as(AllCourses.class);
        AllCourses allCourses =
                RequestBuilder.invokeAPI("https://www.rahulshettyacademy.com", null, "/api/course", RequestMethod.GET, null, null, null, ContentType.JSON).as(AllCourses.class);
        System.out.println(allCourses.getCourses());
    }
}
