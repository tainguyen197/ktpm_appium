package com.example.nguyentrungtai.myapplicationtest;

import android.util.Log;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    MobileDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.out.print("begin");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
            capabilities.setCapability("deviceName", "0b8f96e60604");
                capabilities.setCapability("appPackage", "com.zing.zalo");
        capabilities.setCapability("appActivity", "com.zing.zalo.ui.ZaloLauncherActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    //@org.testng.annotations.Test(dataProvider = "Data")

    @Test
    @UseDataProvider("Data")
    public void testFirstCalculator(String s1, String s2, String s3) {
        System.out.println(s1 + "    " + s2 + "    " + s3);
        System.out.println("Run TestCase 01");
        By  btnLogin = By.id("com.zing.zalo:id/btnLogin");
        By btnAccessPer = By.id("com.android.packageinstaller:id/permission_allow_button");
        By edtNumPhone = By.id("com.zing.zalo:id/edtAccount");
        By edtPass = By.id("com.zing.zalo:id/edtPass");
        By btnNext = By.id("com.zing.zalo:id/btn_next");

        driver.findElement(btnNext).click();
        driver.findElement(btnNext).click();
        driver.findElement(btnNext).click();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        driver.findElement(btnLogin).click();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        driver.findElement(btnAccessPer).click();
        driver.findElement(btnAccessPer).click();


        driver.findElement(edtNumPhone).sendKeys("A");
        driver.findElement(edtPass).sendKeys("nothing");
        driver.findElement(btnLogin).click();

        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//
        MobileElement tvError = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");

        Assert.assertEquals(tvError.getText(),"A");

    }
    @DataProvider
    public static Object[][] Data() {
        // @formatter:off
        return new Object[][] {
                { 0, 0, 0 },
                { 1, 1, 2 },
                /* ... */
        };
        // @formatter:on
    }

    @AfterMethod
    public void End() {
        driver.quit();System.out.println("Xong");
    }
}