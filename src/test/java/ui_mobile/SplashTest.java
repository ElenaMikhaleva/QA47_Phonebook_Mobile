package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SplashTest extends AppiumConfig {

    @Test
    public void splashTest() {
        Assert.assertTrue(new SplashScreen(driver).validateVersionApp("Version 1.0.0"));
    }

    @Test
    public void validateSplashScreenTimeTest(){
        Assert.assertTrue(new SplashScreen(driver).validateSplashscreenToDisappear(6000));
    }
}
