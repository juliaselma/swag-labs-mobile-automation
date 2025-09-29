package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.DriverSetup;

public class Hooks {

    @Before
    public void setupScenario() {
        DriverSetup.initializeDriver();
    }

    @After
    public void tearDownScenario() {
        if (DriverSetup.getDriver() != null) {
            DriverSetup.getDriver().quit();
        }
    }
}
