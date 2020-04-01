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

public class TC04 extends Basejava{
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
               FileUtils.copyFile(scr, new File(p+"\\screenshots\\screenshot06.png"));
        
       }
           @Test(priority=4)
           void count_links() throws IOException{    	  
        	   WebElement alllinks=wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));
        	   List<WebElement> Links=alllinks.findElements(By.tagName("li"));
        	   int count=0;
        	   String s1="";
        	   for(WebElement link:Links)
        	   {
        		   String s=link.getText();
        		   if(!s.equals(""))
     	           {
        			   count++;
        			   s1=s1+s+"\n";
        		   }
        	   }
//        	   System.out.println("Total Number of menu link count on webpage = "+count);
        	   fw=new FileWriter(p+"\\testdata\\testfile03.txt");
               fw.write(s1+"Total Number of menu link count on webpage = "+count);
               fw.close();
           }
           @Test(priority=5)
           void screenshot07() throws IOException{
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();

        	   File scr1=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr1, new File(p+"\\screenshots\\screenshot07.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a")).click();

        	   File scr2=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr2, new File(p+"\\screenshots\\screenshot08.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();

        	   File scr3=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr3, new File(p+"\\screenshots\\screenshot09.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a")).click();

        	   File scr4=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr4, new File(p+"\\screenshots\\screenshot10.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[5]/a")).click();

        	   File scr5=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr5, new File(p+"\\screenshots\\screenshot11.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();

        	   File scr6=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr6, new File(p+"\\screenshots\\screenshot12.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[7]/a")).click();

        	   File scr7=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr7, new File(p+"\\screenshots\\screenshot13.png"));
        
               wd.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a")).click();

        	   File scr8=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
               FileUtils.copyFile(scr8, new File(p+"\\screenshots\\screenshot14.png"));
        
           }
           @Test(priority=6)
           void log_out2() throws IOException{
        	   wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
               wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
               
               fw=new FileWriter(p+"\\testdata\\msg04.txt");
               fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
               fw.close();

               wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
               wd.manage().deleteAllCookies();
               wd.close();
           }
}