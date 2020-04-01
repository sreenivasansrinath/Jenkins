package com.wipro.testcases;
import com.wipro.utilities.*;
import org.testng.annotations.*;
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

public class TC02 extends Basejava {
	org.apache.poi.ss.usermodel.Sheet sheet;
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
            String str[]= {"email","password"};
           wd.findElement(By.name("email")).sendKeys(email);
           wd.findElement(By.name("password")).sendKeys(password);
           wd.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
       }
           @Test(priority=3)
           void screenshot02() throws IOException{
              
               File scr=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot02.png"));
              
       }    
           @Test(priority=4)
           void edit_account() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();
               wd.findElement(By.xpath("//*[@id=\"input-telephone\"]")).clear();
               wd.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("0123456789");
               wd.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();


           }
           @Test(priority=5)
           void screenshot03() throws IOException{
              
        	    File scr=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               BufferedImage bw=ImageIO.read(scr);
               WebElement we=wd.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]"));
               BufferedImage bw1=bw.getSubimage(we.getLocation().getX(), we.getLocation().getY(), we.getSize().getWidth(), we.getSize().getHeight());
               ImageIO.write(bw1, "png",scr);
              
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot03.png"));
             
       }
           @Test(priority=6)
           void log_out() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
               wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
               
               fw=new FileWriter(p+"\\testdata\\testfile02.txt");
               fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
               fw.close();

               wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
               wd.manage().deleteAllCookies();
               wd.close();
           }
 }
