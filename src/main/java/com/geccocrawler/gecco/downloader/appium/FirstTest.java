package com.geccocrawler.gecco.downloader.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author: 画家
 * @date: 2019-04-27
 * @desc:
 */
public class FirstTest {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("9")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("=")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println(result);

        driver.quit();
    }
}
