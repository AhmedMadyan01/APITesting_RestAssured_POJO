package tests;

import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.responses.get_bill.GetBillPOJO;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GetBill {
    String baseURI = ("https://api.non-prod.vf-itaap.engineering.vodafone.com");
    String endPoint = ("/bill-analysis-js/api/v1/bill");
    private static String codeValue;
    private static String bearerToken;

    @BeforeTest
    public void generateAndExtractCode() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setAcceptInsecureCerts(true);
//        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--headless");  // Enable headless mode

        By USERNAME_TEXT_BOX = By.id("identifier");
        By PASSWORD_TEXT_BOX = By.id("password");
        By CONTINUE_BUTTON = By.id("continueButton");
        By COOKIES_OK_BUTTON = By.id("cookieOkButton");

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://hub.dev.external.nonprod.id-euc1.aws.cps.vodafone.com/oidc/authorize?login_hint=OPCO%3AIE&acr_values=urn%3Avodafone%3Aloa%3Asilver&scope=openid+phone+offline_access+profile&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Ftest&state=d1ccf7f8-6033-45c7-8382-3609586ba8fc&nonce=728e5fa1-fa98-4394-a757-a5b463ba4120&client_id=OneApp");
        System.out.println(webDriver.getCurrentUrl());
        Thread.sleep(5000);
        webDriver.findElement(COOKIES_OK_BUTTON).click();
        webDriver.findElement(USERNAME_TEXT_BOX).sendKeys("0878004032");
        webDriver.findElement(PASSWORD_TEXT_BOX).sendKeys("Aa123456!");
        webDriver.findElement(CONTINUE_BUTTON).click();
        Thread.sleep(5000);

        String url = webDriver.getCurrentUrl();
        String[] code = StringUtils.substringsBetween(url, "code=", "&state");

        codeValue = Arrays.toString(code).replaceAll("[\\[\\]]", "");
        System.out.println("Code= " + codeValue);
    }

    @BeforeTest(dependsOnMethods = "generateAndExtractCode")
    public void generateAndExtractBearerToken() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept", "application/json");

        Map<String, String> formParam_Body = new HashMap<>();
        formParam_Body.put("grant_type", "authorization_code");
        formParam_Body.put("client_id", "OneApp");
        formParam_Body.put("client_secret", "dve3fgpo91az22one");
        formParam_Body.put("redirect_uri", "https://example.com/test");
        formParam_Body.put("code", codeValue);


        Response response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.POST)
                .setBaseUri("https://hub.dev.external.nonprod.id-euc1.aws.cps.vodafone.com")
                .setBasePath("/oidc/token")
                .addHeaders(headers)
                .addFormParams(formParam_Body)
                .sendRequest();
        bearerToken = "Bearer " + response.getBody().jsonPath().get("id_token");
        System.out.println("Access token: " + bearerToken);
    }

    @Test
    public void sendRequest() {
        GetBillPOJO getBillPOJO = new GetBillPOJO();
        Map<String, String> query_map = new HashMap<>();
        query_map.put("billingAccount.id", "BI789946666");
        query_map.put("limit", "12");

        Map<String, String> headers_map = new HashMap<>();
        headers_map.put("vf-country-code", "IE");
        headers_map.put("vf-Project", "oneapp");
        headers_map.put("Cookie", "CF_AppSession=n7077775dad2bdd25; CF_Authorization=eyJhbGciOiJSUzI1NiIsImtpZCI6IjRmYjY4ODBmNWExZjMzNTNkZmMzMTc1ZTk2YzcwNWZjOGRlOGNmM2QzODRmNjJmZTc5ZjhjYzYzOTM3NDkzMjEifQ.eyJhdWQiOlsiOWFmYjAzMjFmNjMxNGZlOTUyZTNmNjAwMmUzOTVkYWExNDNkNjA0ZDg2ZDQ4N2VmZWI1ZDI0ODk5YzQwYjFiZCJdLCJlbWFpbCI6Im1hcnlhbS5laGFiQHZvZGFmb25lLmNvbSIsImV4cCI6MTY5MDM1NTY0MiwiaWF0IjoxNjkwMjY5MjQyLCJuYmYiOjE2OTAyNjkyNDIsImlzcyI6Imh0dHBzOi8vY2xvdWRlbmdpbmVlcmluZy5jbG91ZGZsYXJlYWNjZXNzLmNvbSIsInR5cGUiOiJhcHAiLCJpZGVudGl0eV9ub25jZSI6Ik42TW5kODgweFpYNzZ3N2EiLCJzdWIiOiJmZWNmMTY2OC0zYWRiLTVkMjYtYWExNC0yODMxODc1YWUwODEiLCJjb3VudHJ5IjoiRUcifQ.Ex-CD_GKFkyl54IhxuzYljCmq-9fTbDGx5bSXOYxfIQtz3QT-2OA_5YhIkLGDL7KIn_GzwLSWJU4SgYmZsKfQjPTCAe-8URXcOqBApA38xWJu1TQB0ymMzkRHXm5DV5hzg6FNRt7sipqnHlpQc-m1-BVpKvVIFM-WvqOfJV_nNPJbYns-I4NShHrrqmArjlWnvETZVbkMtYQdrL7yEMAJEPx57VyTOCqYWr6qzGXWw3BZlgtIexSdOj9bA4UFLHi2Dh109fScaKCemDFkZ_pAv02b3k54hiVSogm6YJE5SlvMMqsTObu5nolZpf50xWFDCtKVUQglQb1W7pHCorEfg");
        headers_map.put("Authorization", bearerToken);
        headers_map.put("CF-Access-Client-Secret", "6423bc67b7f9579917b01ba92590a7ffc2144800aff6e32864c5b2459c603b75");
        headers_map.put("CF-Access-Client-Id", "e022a18ccb80b93937a395cf7e539d24.access");

        Response response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.POST)
                .setBaseUri(baseURI)
                .setBasePath(endPoint)
                .addHeaders(headers_map)
                .addQueryParams(query_map)
                .sendRequest();

//        Response response = RequestBuilder.performRequest(baseURI, "443", endPoint, null, RequestMethod.GET, headers_map, null, query_map, null, HttpStatus.SC_OK, false, ContentType.JSON);
//        List<GetBill> getBills = response.as(new TypeRef<>() {
//        });
//        System.out.println(getBills.get(0));
        System.out.println(response.getBody().asString());
    }
}