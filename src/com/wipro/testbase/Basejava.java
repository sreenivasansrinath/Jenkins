package com.wipro.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Basejava {
    public WebDriver wd;
    protected String p ="E:\\Selenium\\Selenium_Sample_TC1\\Resources";
    @BeforeSuite
    public void base() throws IOException {
        Properties pr=new Properties();
        FileInputStream fs=new FileInputStream(p+"\\config\\config.properties");
        pr.load(fs);
        String url=pr.getProperty("url");
        String dP =pr.getProperty("driverpath");
        //System.setProperty("webdriver.chrome.driver", "D:\\workplace sreeni\\Selenium_Sample_TC\\Selenium_Sample_TC\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", dP );
        
        wd=new ChromeDriver();
        wd.get(url);
        //wd.quit();
    }
}