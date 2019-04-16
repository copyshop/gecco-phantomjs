package com.geccocrawler.gecco.downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author: heyin
 * @date: 2019-04-16
 * @desc: 怎么回事，会出现验证码（用浏览器模拟出现验证码，但是真正的手动操作不会出现），这个有待研究是什么原理，
 */
public class SogouwxDownloader {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\programfile\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        String url = "https://weixin.sogou.com/";
        driver.get(url);
        driver.findElement(By.id("query")).sendKeys(new String[] {"深圳"});
        driver.findElement(By.cssSelector("input.swz")).click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //获取当前浏览器的信息
        System.out.println("title:" + driver.getTitle());
        System.out.println("currentUrl:" + driver.getCurrentUrl());
        // System.out.println("body:" + driver.getPageSource());

        int index = 0;
        List<WebElement> webElementList = driver.findElements(By.cssSelector("div.news-box>ul.news-list>li"));
        List<String> urlList = new ArrayList<>();
        for (WebElement element : webElementList) {
            System.out.println("====================" + (index++) + "====================");
            WebElement wele = element.findElement(By.cssSelector(".txt-box h3 a"));
            System.out.println(wele.getText() + " >>> " + wele.getAttribute("href"));
            urlList.add(wele.getAttribute("href"));
        }

        for (String article : urlList) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("url: " + article);
            driver.get(article);
            System.out.println(driver.findElement(By.tagName("body")).getText());
            System.out.println("========================================");
        }
    }
}
