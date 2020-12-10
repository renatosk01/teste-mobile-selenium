package com.everis.beca;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

;

public class TesteGoogleAndroid {

        private AppiumDriver<MobileElement> driver;


        @Before
        public void setup() throws MalformedURLException {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator_container");
                String appFile = "C:\\Users\\rsantmor\\Downloads\\android\\selendroid-test-app-0.17.0.apk";
                cap.setCapability(MobileCapabilityType.APP, appFile);
                cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
                cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                //Pagina Google

        }

        @After
        public void finishTest() {
                driver.closeApp();
                driver.quit();
        }






        @Test
        public void textoWebViewTeste(){
                WebDriverWait wait = new WebDriverWait(driver, 40);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/buttonStartWebview")));
                element.click();

                WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.selendroid.testapp:id/webviewLocation")));
                String texto1 = texto.getText();
                assertEquals("WebView location", texto1);

        }

        @Test
        public void goHomeTeste(){
                WebDriverWait wait = new WebDriverWait(driver, 40);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/buttonStartWebview")));
                element.click();

                WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/goBack")));
                element2.click();

                WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/title")));
                String texto1 = texto.getText();
                assertEquals("selendroid-test-app", texto1);

        }


}