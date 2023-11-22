package com.myBank.testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestData {
	

	public static void readData() throws IOException {
		String data = null;
        String filePath = "C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\testng-appium-myBank-browserstack-sdk\\"
        		+ "testng-appium-app-browserstack-sdk\\android\\testng-examples\\src\\test\\java\\com\\myBank\\testdata\\testdata.xlsx";
        
        //locate file
        FileInputStream fis = new FileInputStream(filePath);
        
        //read the file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        //get the sheet
        XSSFSheet sheet1 = workbook.getSheet("Sheet1");
        XSSFSheet sheet2 = workbook.getSheet("Sheet2");
        
        //get the data per cell
        //int rows = sheet1.getLastRowNum();
        //int cols = sheet1.getRow(1).getLastCellNum();
        
        int rows = 3;
        int cols = 2;
        
        for(int r=0; r<=rows; r++) {
        	XSSFRow row=sheet1.getRow(r);
        	
        	for(int c=0; c<cols; c++) {
        		XSSFCell cell=row.getCell(c);
        		
        		switch(cell.getCellType())
        		{
        		case STRING: System.out.print(cell.getStringCellValue()); break;
        		case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
        		
        		}
        		System.out.print(" -- ");
        	}
        	System.out.println();  	
        }
        
        
	}
}
