package com.wipro.utilities;
import com.wipro.testbase.*;

 

import java.io.File.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

 

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

 

public class Testutil extends Basejava {
    static HSSFWorkbook book;
    static Sheet sheet;
    static FileWriter fw;
    
    static  public Object [][] getdata(String sheetname) throws IOException{
            FileInputStream fs=new FileInputStream("E:\\Selenium\\Selenium_Sample_TC1\\Resources\\testdata\\Datasheet.xls");
             book=new HSSFWorkbook(fs);
             sheet=book.getSheet(sheetname);
             DataFormatter df=new DataFormatter();
             
             Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
                 for(int i=0;i<sheet.getLastRowNum();i++) {
                     
               for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
                data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
               } 
           }return data;
    }
         }