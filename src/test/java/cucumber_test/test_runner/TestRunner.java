package cucumber_test.test_runner;

import io.cucumber.testng.CucumberOptions;
import utilities.test_base.TestBase;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/cucumber_test/feature"},
                glue = {"cucumber_test/step_definition"},
                tags = ("@GETListOfUsers"),
                plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        )

public class TestRunner extends TestBase {
}