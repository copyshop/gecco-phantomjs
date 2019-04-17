package com.geccocrawler.gecco.downloader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
 * 绕过chrom 无头浏览的限制 https://blog.csdn.net/Revivedsun/article/details/81785000
 */
public class SogouwxDownloader {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\programfile\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        //
        // File file = new File("C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe");
        // options.setBinary(file);
        // options.addArguments("--user-data-dir=C:\\Users\\yin.he\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("lang=zh_CN.UTF-8");
        // 不加载图片
        // options.addArguments("blink-settings=imagesEnabled=false");
        //window.navigator.webdriver 一定不能等于true
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
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
        for (WebElement element : webElementList) {
            System.out.println("====================" + (index++) + "====================");
            element.findElement(By.cssSelector(".txt-box h3 a")).click();
            System.out.println(element.getText());
        }

        String currentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> it = allWindow.iterator();
        while (it.hasNext()) {
            if (currentWindow == it.next()) {
                continue;
            }
            WebDriver window = driver.switchTo().window(it.next());//切换到新窗口
            System.out.println(window.getTitle());
            //关闭新窗口
            window.close();
        }
        driver.switchTo().window(currentWindow);//回到原来页面
    }
}
