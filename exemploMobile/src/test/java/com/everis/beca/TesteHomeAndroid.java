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

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

;

public class TesteHomeAndroid {

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
        }

        @After
        public void finishTest() {
                driver.closeApp();
                driver.quit();
        }


        @Test
        public void textoHello(){
                String texto = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
                System.out.println(texto);
                assertEquals("Hello Default Locale, Selendroid-test-app!", texto);
        }

        @Test
        public void textoLocalization(){
                String texto1 = driver.findElementByXPath("//*[@id=selectedElementContainer]/div/div[2]/div/div[2]/div/div/div/div/div/table/tbody/tr/td[2]").getText();
                System.out.println(texto1);
                assertEquals("Localization (L10n) locator test", texto1);
        }

//        @Test   //Using XPath locators is not recommended and can lead to fragile tests.
//        public void buttonEnTeste(){
//                driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=l10nCD]/android.widget.TextView").click();
//                String texto = driver.findElementByXPath("//android.widget.Button[@content-desc=waitingButtonTestCD]").getText();
//                assertEquals("Show Progress Bar for a while", texto);
//        }

        @Test
        public void buttonGoogleTeste(){

                WebDriverWait wait = new WebDriverWait(driver, 40);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/buttonStartWebview")));
                element.click();

                WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1")));

                String texto1 = texto.getText();
                assertEquals("'Say Hello'-Demo", texto1);
        }

        @Test
        public void buttonPastaTeste(){
                WebDriverWait wait = new WebDriverWait(driver, 40);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/startUserRegistration")));
                element.click();

                WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.selendroid.testapp:id/label_username")));
                String texto1 = texto.getText();
                assertEquals("Username", texto1);
        }

        @Test
        public void campoDeTexto() {
                driver.findElementById("io.selendroid.testapp:id/my_text_field").sendKeys("Teste 123");
                driver.findElementById("io.selendroid.testapp:id/input_adds_check_box").click();
                String result = driver.findElementById("io.selendroid.testapp:id/input_adds_check_box").getText();
                //System.out.println("\n\n===> " + result + "\n\n");
                assertEquals("Teste 123", result);
        }

        @Test
        public void buttonShowPBFWteste() {
                WebDriverWait wait = new WebDriverWait(driver, 40);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("io.selendroid.testapp:id/waitingButtonTest")));
                element.click();

                WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("io.selendroid.testapp:id/label_username")));
                String texto1 = texto.getText();

                assertEquals("Username", texto);
        }

        @Test
        public void checkBoxTeste() {
                boolean isCheced;
                if (driver.findElementById("io.selendroid.testapp:id/input_adds_check_box").isSelected()) {
                        isCheced = true;
                        assertEquals(true, isCheced);

                } else {
                        isCheced = false;
                        assertEquals(false, isCheced);
                }



        }








}