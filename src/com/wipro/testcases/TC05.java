package com.wipro.testcases;
import com.wipro.utilities.*;
import org.testng.annotations.*;

import java.util.List;
import com.wipro.testbase.Basejava;
import com.wipro.testcases.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.Sheet;
public class TC05 extends Basejava{
	 Sheet sheet;
    FileWriter fw; 
    
        @Test(priority=1)
         void myaccount_1() {
            wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
            wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        }
        @DataProvider
        Object[][] data() throws IOException {
        Object[][] arro= Testutil.getdata("Sheet2");
                return arro; 
        }
       @Test(dataProvider="data",priority=2)
        void log_in(String email,String password) {
           wd.findElement(By.name("email")).sendKeys(email);
           wd.findElement(By.name("password")).sendKeys(password);
           wd.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
       }
           @Test(priority=3)
           void screenshot15() throws IOException{
              
        	   File scr=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot15.png"));
        
       }
           @Test(priority=4)
           void your_store() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"logo\"]/h1/a")).click();

               wd.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[1]/a")).click();

           }
           @Test(priority=5)
           void fav_brand() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/a")).click();
        	   File scr1=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr1, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots01.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();


               wd.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/a")).click();
        	   File scr2=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr2, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots02.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();

               
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/a")).click();
        	   File scr3=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr3, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots03.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();

               
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
        	   File scr4=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr4, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots04.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();

               
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/a")).click();
        	   File scr5=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr5, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots05.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();

               
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[5]/div/a")).click();
        	   File scr6=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr6, new File(p+"\\screenshots\\allbrand_screenshots\\screenshots06.png"));
               wd.findElement(By.xpath("//*[@id=\"product-manufacturer\"]/ul/li[2]/a")).click();

           }
           @Test(priority=6)
           void log_out3() throws IOException{
        	   wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
               wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
               
               fw=new FileWriter(p+"\\testdata\\msg05.txt");
               fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
               fw.close();

               wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
               wd.manage().deleteAllCookies();
               wd.close();
           }
}