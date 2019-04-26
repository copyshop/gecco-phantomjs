package com.geccocrawler.gecco.downloader;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * author: heyin
 * date: 2019-04-25
 * desc: 模拟新浪登录
 */
public class SinaLogin {
    
    public static void main(String[] args) {
        scanCode();
    }
    
    /**
     * 扫码登录
     */
    public static void scanCode() {
        
        System.setProperty("webdriver.chrome.driver", "D:\\programfile\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        options.addArguments("lang=zh_CN.UTF-8");
        // 不加载图片(扫码登录需要加载图片)
        // options.addArguments("blink-settings=imagesEnabled=false");
        //window.navigator.webdriver 一定不能等于true
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        String url = "https://weibo.com";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        
        driver.findElement(By.cssSelector("div.clearfix.tab>a:last-child")).click();
        
        WebElement element = driver.findElement(By.cssSelector("div.clearfix.tab>a:last-child"));
        
        WebDriverWait driverWait = new WebDriverWait(driver, 120);
        driverWait.until(ExpectedConditions.titleContains("我的首页"));
        
        System.out.println("title:" + driver.getTitle());
        System.out.println("currentUrl:" + driver.getCurrentUrl());
    }
    
    /**
     * 表单登录
     */
    public static void formLogin() {
        System.setProperty("webdriver.chrome.driver", "D:\\programfile\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        options.addArguments("lang=zh_CN.UTF-8");
        // 不加载图片
        options.addArguments("blink-settings=imagesEnabled=false");
        //window.navigator.webdriver 一定不能等于true
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        String url = "https://weibo.com";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        
        driver.findElement(By.cssSelector("input#loginname")).click();
        driver.findElement(By.cssSelector("input#loginname")).sendKeys(new String[] {"huajia201904@126.com"});
        driver.findElement(By.cssSelector("input[type=\"password\"]")).click();
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(new String[] {"heller123456"});
        driver.findElement(By.cssSelector("div>a.W_btn_a")).click();
        
        System.out.println("title:" + driver.getTitle());
        System.out.println("currentUrl:" + driver.getCurrentUrl());
    }
}
