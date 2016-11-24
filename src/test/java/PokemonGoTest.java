/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ca.brendanjames.pokemongoautomation.AkazeImageFinder;
import ca.brendanjames.pokemongoautomation.TestdroidImageRecognition;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.slf4j.LoggerFactory;

/**
 *
 * @author brendancrawford
 */
public class PokemonGoTest extends TestdroidImageRecognition {
    
    public PokemonGoTest() throws Exception {
        super();
        logger = LoggerFactory.getLogger(PokemonGoTest.class);
    }
    
    @BeforeClass
    public static void setUp() throws Exception {
        
        AkazeImageFinder.setupOpenCVEnv();
        driver = getAndroidDriver();
        
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
        if (driver != null) {
            log("Quitting Appium driver at tearDown");
            driver.quit();
        } else {
            log("driver was null at tearDown");
        }
    }
    
    @Test
    public void testHelloWorld() throws Exception{
        log("Image Recognition sample script started.");
        takeScreenshot("Before hideKeyboard");
        try {
          driver.hideKeyboard();
        } catch (Exception e) {
          log("Keyboard not present; going forward.");
        }

        findImageOnScreen("niantic_logo");
        log("Success.");
    }
}
