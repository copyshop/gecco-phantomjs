package com.geccocrawler.gecco.downloader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * author: heyin
 * date: 2019-04-26
 * desc:
 */
public class ChromeProxyBrower {
    
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--proxy-server=124.206.133.227:80");
        WebDriver driver = new ChromeDriver(options);
    }
}
