package stepDefinitions;

import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("urlN11"));

    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            TakesScreenshot ts = ((TakesScreenshot) Driver.getDriver());
            byte[] inMemory = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(inMemory, "image/png", "screenshot name");

        }
         Driver.quitDriver();
    }
}

