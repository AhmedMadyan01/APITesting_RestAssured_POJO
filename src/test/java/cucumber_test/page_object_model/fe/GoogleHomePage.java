package cucumber_test.page_object_model.fe;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.test_base.TestBase;

public class GoogleHomePage {
    /**
     * Locators, and Variables
     */
    private static final By google_logo = By.className("lnXdpd");
    private static final By google_SearchBar = By.name("q");
    private static final By google_SearchButton = By.name("btnK");

    private static final String google_URL = ("https://www.google.com/");

    /**
     * Methods
     */
    public static void navigateToGoogleHomePage() {
        TestBase.getDriver().navigate().to(google_URL);
        TestBase.getDriver().manage().window().maximize();
    }

    public static void validateThatUserRedirectedSuccessfully() {
        Assert.assertEquals(TestBase.getDriver().getCurrentUrl(), google_URL);
    }

    public static void validateThatGoogleLogoIconExists() {
        Assert.assertTrue(TestBase.getDriver().findElement(google_logo).isDisplayed());
    }

    public static void validateThatGoogleSearchBarExists() {
        Assert.assertTrue(TestBase.getDriver().findElement(google_SearchBar).isDisplayed());
    }

    public static void validateThatGoogleSearchButtonsDisplayed() {
        Assert.assertTrue(TestBase.getDriver().findElement(google_SearchBar).isDisplayed());
        Assert.assertTrue(TestBase.getDriver().findElement(google_SearchBar).isEnabled());
    }

    public static void validateThatGoogleSearchButtonClickable() {
        Assert.assertTrue(TestBase.getDriver().findElement(google_SearchBar).isEnabled());
    }
}
