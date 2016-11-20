/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author brendancrawford
 */
public class PokemonGoTest {
    
    protected AndroidDriver driver;
    
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("appPackage", "com.nianticlabs.pokemongo");
        capabilities.setCapability("launchActivity","com.unity3d.player.UnityPlayerActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","5.0.1");
        capabilities.setCapability("deviceName","0ed66d20");
        
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    @Test
    public void testHelloWorld(){
        WebElement el = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");
        assertNotNull(el);
    }
}
