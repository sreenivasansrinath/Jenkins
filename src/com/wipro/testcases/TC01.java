package com.wipro.testcases;

import com.wipro.utilities.*;
import org.testng.annotations.*;
import com.wipro.testbase.Basejava;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.util.Random;

class TC01 extends Basejava {

	Sheet sheet;
	FileWriter fw;

	@Test(priority = 1)
	void myaccount() {
		wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		wd.findElement(By.linkText("Register")).click();
	}

	@DataProvider
	Object[][] data() throws IOException {
		Object[][] arro = Testutil.getdata("Sheet1");
		return arro;
	}

	@Test(dataProvider = "data", priority = 2)
	void register(String fn, String lastname, String email, String telephone, String password, String confirm) {
		

		wd.findElement(By.name("firstname")).sendKeys(fn);
		wd.findElement(By.name("lastname")).sendKeys(lastname);
		wd.findElement(By.name("email")).sendKeys(email);
		wd.findElement(By.name("telephone")).sendKeys(telephone);
		wd.findElement(By.name("password")).sendKeys(password);
		wd.findElement(By.name("confirm")).sendKeys(confirm);
	}

	@Test(priority = 3)
	public void check() throws IOException, InterruptedException {
		fw = new FileWriter(new File(p+"\\testdata\\testfile01.txt"));

		if (wd.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected())
			fw.write("The checkbox is checked");
		else
			fw.write("The checkbox is not checked");
		fw.close();

	}

	@Test(priority = 4)
	public void cont() throws InterruptedException {
		wd.findElement(By.cssSelector("input[type='checkbox']")).click();
		wd.findElement(By.cssSelector("input[type='submit']")).click();

	}

	@Test(priority = 5)
	void screenshot01() throws IOException,  InterruptedException {

		File scr = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(p + "\\screenshots\\screenshot01.png"));

		fw = new FileWriter(p + "\\testdata\\msg01.txt");
		fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
		fw.close();
		wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		wd.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();

		fw = new FileWriter(p + "\\testdata\\msg02.txt");
		fw.write(wd.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText());
		fw.close();

		wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		wd.quit();
		 
	}
	
}
