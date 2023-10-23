package unit_test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UnitTest {
    private static final String TEST_DATA_FILE_PATH = ("src/test/resources/test_data/fe/expected/OnBoardingScreens.json");

    public static void main(String[] args) {
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("token", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjAzZDA3YmJjM2Q3NWM2OTQyNzUxMGY2MTc0ZWIyZjE2NTQ3ZDRhN2QiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vdmYtaWUtZmRuLXByZC10b3ppLTAxIiwiYXVkIjoidmYtaWUtZmRuLXByZC10b3ppLTAxIiwiYXV0aF90aW1lIjoxNjk3NDYwNTA1LCJ1c2VyX2lkIjoiQXZ0WnpQZXk4RWhnaVFOV0pFRDR6dTYzOHpFMiIsInN1YiI6IkF2dFp6UGV5OEVoZ2lRTldKRUQ0enU2Mzh6RTIiLCJpYXQiOjE2OTc0NjA1MDUsImV4cCI6MTY5NzQ2NDEwNSwiZW1haWwiOiJ0ZXN0YWNjMUB0b3ppYXBwLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJlbWFpbCI6WyJ0ZXN0YWNjMUB0b3ppYXBwLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.Ab5O4W-gZKiMZBnZ6ccV4INPptZJ9-Lml7WtFanyAmIWqVZbvToFrFt179iWL-Boy099EMDWraRgDVHTw6wM-z9ZxOZrFBaUP9ZUgQXD17ZoCxtLhhcQoKxlwTywEQOKHyWikOmOSVuWXOB2T_6G61X5Nrdum2Rf5kvRSuaRkKPc20wbiQpoBx3FrRzJ_vIVfYDJT4x141A3WKrZq8IVxfxj3YbhqDK9J3eZg28kGfiuOVr1QpH8ADQYGpsh8AEy4SRKz4IzZjCUoHQ4sD3-fr4R5k1sevajBDnRZpMUcDJTaiFkbHdATtKuqE03aojjZSsnq4TTTgzSwS0kYfOqwg");

        Response response = given().log().all()
                .headers(headersMap)
                .and()
                .body("{\n" +
                        "    \"displayName\": \"TestAcc1\"\n" +
                        "}")
                .when()
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .patch("https://api.prod.to-zi.com/profile-management-api/profile/testacc1@toziapp.com")
                .then()
                .log().all()
                .extract().response();
        System.out.println(response.getBody().prettyPrint());
//        System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
//        String string = JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_4", JSONDataManager.Types.STRING).toString().trim();
//        Log4JLogger.logINFO(UnitTest.class,string);
//        String date = ("2022-09-09T00:00:00Z");
//        Log4JLogger.logINFO(UnitTest.class,"Year: " + extractYearFromISODate(date) + "\nMonth: " + extractMonthFromISODate(date));
    }

    private static String extractYearFromISODate(String isoExtendedDate) {
        return String.valueOf(LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getYear());
    }

    private static String extractMonthFromISODate(String isoExtendedDate) {
        return LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getMonth().name();
    }
}