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
import org.apache.poi.ss.usermodel.Sheet;
public class TC03 extends Basejava{
	
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
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot04.png"));
        
       }
           @Test(priority=4)
           void components_menu() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();
 
               File scr=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot05.png"));
        
           }
           @Test(priority=5)
           void fetch_name() throws IOException{
           
        	   fw=new FileWriter(p+"\\output_data\\prize.txt");
        	   String s1=wd.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).getText();
        	   String s2=wd.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/p[2]/span[1]")).getText();

               fw.write("Name= "+s1+"\n"+"Prize= "+s2.substring(1));
               fw.close();

           }
          /* @Test(priority=6)
           void click_addtocart() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();

           }
           
          @DataProvider
           Object[][] data1() throws IOException {
           Object[][] arro= Testutil.getdata("Sheet3");
                   return arro; 
           }
           @Test(dataProvider="data1",priority=7)
           void fill_details(String checkbox,String text) {
               String[] a= {"checkbox","text"};
            int b=Integer.parseInt(checkbox);
            if(b==3) {
                wd.findElement(By.xpath("//*[@id=\"input-option223\"]/div[1]/label/input")).click();
                     }
                wd.findElement(By.xpath("//*[@id=\"input-option208\"]")).clear();
                wd.findElement(By.xpath("//*[@id=\"input-option208\"]")).sendKeys(text);

           }*/
           @Test(priority=8)
           void log_out1() throws IOException{
        	   wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
               wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
               
               fw=new FileWriter(p+"\\testdata\\msg03.txt");
               fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
               fw.close();

               wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
               wd.manage().deleteAllCookies();
               wd.close();
           }
           
}