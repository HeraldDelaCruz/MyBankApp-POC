package com.myBank.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestData {
	
    static String excelpath = "C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\testng-appium-myBank-browserstack-sdk\\"
    		+ "testng-appium-app-browserstack-sdk\\android\\testng-examples\\src\\test\\java\\com\\myBank\\testdata\\testdata.xlsx";
    
   
	public static Object amountTestData() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(new String(excelpath));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			Sheet sheet = wb.getSheet("Amount");       
			int lastRowNum = sheet.getLastRowNum()-1;
			Row row = sheet.getRow(lastRowNum);
			
			if (row != null) {
				Cell cell = row.getCell(0);
				
				if (cell != null) {
			
					switch(cell.getCellType()) {
						case STRING:
							return cell.getStringCellValue();
							
						case NUMERIC:
							return (float) cell.getNumericCellValue();
							
						case BLANK:	
							Reporter.log("Data not found",true);
							return null;	
							
						}//switch
					
					}//cell
				
				}//row
			
			}//try
		
		catch(Throwable e) {
			e.printStackTrace();
			}
		
		return null;
		
	}
	
	
	public static String userTestData(String sheetName,int rowIndex,int cellIndex) {
		try {
        FileInputStream fis = new FileInputStream(new String(excelpath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        
			Sheet sheet = wb.getSheet("UserDetails");
			Row row = sheet.getRow(rowIndex);
			
			if (row != null) {
				
				Cell cell = row.getCell(cellIndex);
				
				if (cell != null) {
					
					if (cell.getCellType() == CellType.STRING) {
						return cell.getStringCellValue().toString();
					}
					if (cell.getCellType() == CellType.NUMERIC) {
						float numType = (float) cell.getNumericCellValue();
						
						DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); 
				    	String strFormatted = decimalFormat.format(numType);
				    		
						return strFormatted.toString();
						
					}
					else if (cell.getCellType() == CellType.BLANK ) {
						Reporter.log("Cell is empty");
						throw new IOException("blank cell");
					}
					else { //celltype
						Reporter.log("Only String and Numeric is supported");
						return null;
					}	
				}
				else { // cell
					Reporter.log("cell value is null");
					return null;
				}
			}
			else { //row
				Reporter.log("row value is null");
			return null;
				}
		}
		catch(IOException e) {
			e.printStackTrace();
            return null;
			}
	}
		
	public String[] HeaderField = {
			userTestData("UserDetails",0,0), // Name
			userTestData("UserDetails",0,1), // Account Num
			userTestData("UserDetails",0,2), // Email ID
			userTestData("UserDetails",0,3), // Mobile Num
			userTestData("UserDetails",0,4), // IFSC Code
			userTestData("UserDetails",0,5)  // Current Balance
			};
	
	public String[] CyrilDetails = {
			userTestData("UserDetails",1,0),
			userTestData("UserDetails",1,1),
			userTestData("UserDetails",1,2),
			userTestData("UserDetails",1,3),
			userTestData("UserDetails",1,4),
			userTestData("UserDetails",1,5)
			};
	
	public String[] NeomiDetails = {
			userTestData("UserDetails",2,0),
			userTestData("UserDetails",2,1),
			userTestData("UserDetails",2,2),
			userTestData("UserDetails",2,3),
			userTestData("UserDetails",2,4),
			userTestData("UserDetails",2,5)
			};
	
	public String[] ShebonDetails = {
			userTestData("UserDetails",3,0),
			userTestData("UserDetails",3,1),
			userTestData("UserDetails",3,2),
			userTestData("UserDetails",3,3),
			userTestData("UserDetails",3,4),
			userTestData("UserDetails",3,5)
			};
	
	public String[] ChandichenDetails = {
			userTestData("UserDetails",4,0),
			userTestData("UserDetails",4,1),
			userTestData("UserDetails",4,2),
			userTestData("UserDetails",4,3),
			userTestData("UserDetails",4,4),
			userTestData("UserDetails",4,5)
			};
	
	public String[] NikitaDetails = {
			userTestData("UserDetails",5,0),
			userTestData("UserDetails",5,1),
			userTestData("UserDetails",5,2),
			userTestData("UserDetails",5,3),
			userTestData("UserDetails",5,4),
			userTestData("UserDetails",5,5)
			};
	
	public String[] ChandniDetails = {
			userTestData("UserDetails",6,0),
			userTestData("UserDetails",6,1),
			userTestData("UserDetails",6,2),
			userTestData("UserDetails",6,3),
			userTestData("UserDetails",6,4),
			userTestData("UserDetails",6,5)
			};
	
	public String[] AlkaDetails = {
			userTestData("UserDetails",7,0),
			userTestData("UserDetails",7,1),
			userTestData("UserDetails",7,2),
			userTestData("UserDetails",7,3),
			userTestData("UserDetails",7,4),
			userTestData("UserDetails",7,5)
			};
	
	public String[] AthulDetails = {
			userTestData("UserDetails",8,0),
			userTestData("UserDetails",8,1),
			userTestData("UserDetails",8,2),
			userTestData("UserDetails",8,3),
			userTestData("UserDetails",8,4),
			userTestData("UserDetails",8,5)
			};
	
	public String[] AshwinDetails = {
			userTestData("UserDetails",9,0),
			userTestData("UserDetails",9,1),
			userTestData("UserDetails",9,2),
			userTestData("UserDetails",9,3),
			userTestData("UserDetails",9,4),
			userTestData("UserDetails",9,5)
			};
	
	public String[] MeenakshiDetails = {
			userTestData("UserDetails",10,0),
			userTestData("UserDetails",10,1),
			userTestData("UserDetails",10,2),
			userTestData("UserDetails",10,3),
			userTestData("UserDetails",10,4),
			userTestData("UserDetails",10,5)
			};

	
	
	
		public static String[] userTestData2() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(new String(excelpath));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
				
			Sheet sheet = wb.getSheetAt(0);       
			int lastRowNum = sheet.getLastRowNum();
			Row row = sheet.getRow(lastRowNum);
			int a = sheet.getPhysicalNumberOfRows();
			
			System.out.println("physical: "+a);
			
		}
		catch(Throwable e) {
			e.printStackTrace();
			}
		
		return null;
	}
	
	
	@Test
	public void getData() throws IOException {
		Object d = amountTestData();
		String[] a = userTestData2();
		System.out.println(d);
		System.out.println(a);
		System.out.println(AshwinDetails[5]);
		
	}
}

	
	
