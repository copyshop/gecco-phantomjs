package com.geccocrawler.gecco.downloader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author: heyin
 * @date: 2019-04-16
 * @desc: chrom 下载地址 http://npm.taobao.org/mirrors/chromedriver/
 */
public class BaiduDownloader {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\programfile\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // 设置无头浏览
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        String url = "http://www.baidu.com";
        driver.get(url);

        driver.findElement(By.id("kw")).sendKeys(new String[] {"hello"});
        driver.findElement(By.id("su")).click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //获取当前浏览器的信息
        System.out.println("title:" + driver.getTitle());
        System.out.println("currentUrl:" + driver.getCurrentUrl());
        driver.quit();
    }
}
