package users;

import api.driver.APIActions;
import api.driver.RequestMethod;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetListUsers {
    String baseURI = ("https://reqres.in");
    String basePath = ("/api/users");

//    @Test
//    public void sendRequest() {
//        HashMap<String, String> query = new HashMap<>();
//        query.put("page", "2");
//
//        Users users;
//        Response response = RestAssured.given().baseUri(baseURI).basePath(basePath).queryParams(query).get().then().extract().response();
//        users = response.as(Users.class);
//
//        response.getCookie("")
//        System.out.println(users.getData().get(0).getFirst_name());
//    }

    @Test
    public void getCFAuthorization(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://api.non-prod.vf-itaap.engineering.vodafone.com/bill-analysis-js/api/v1/bill?billingAccount.id=190190");

//        Response response =
                RestAssured.given().get("https://api.non-prod.vf-itaap.engineering.vodafone.com/bill-analysis-js/api/v1/bill?billingAccount.id=1901990112").then().log().all().extract().response();
//
//        System.out.println(response.asPrettyString());
//
//        System.out.println(response.getCookie("CF_Authorization"));
    }
}
