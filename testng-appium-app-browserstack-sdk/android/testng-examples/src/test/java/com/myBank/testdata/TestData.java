package com.myBank.testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestData {
	
    static String excelpath = "C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\testng-appium-myBank-browserstack-sdk\\"
    		+ "testng-appium-app-browserstack-sdk\\android\\testng-examples\\src\\test\\java\\com\\myBank\\testdata\\testdata.xlsx";
   

	public static Object excelTestData(int sheetIndex,int rowIndex,int cellIndex) {
		try {
        FileInputStream fis = new FileInputStream(new String(excelpath));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        
        if (row != null) {
        	Cell cell = row.getCell(cellIndex);
        	
        	if (cell != null) {
        		if (cell.getCellType() == CellType.STRING) {
        			return cell.getStringCellValue();
        		}
        		else if (cell.getCellType() == CellType.NUMERIC){
        			return (float) cell.getNumericCellValue();
        		}
        		else if (cell == null ) {
        			Reporter.log("Cell is empty");
        			return null;
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
		
	
	public static final String[] HeaderField = {"Name:","Account Number :","Email Id :","Mobile Number :","IFSC Code","Current balance :"};
	public static final String[] CyrilDetails = {"Cyril","9111234561644","cyrilshaji38@gmail.com","1234567890","ABC09876543","15,000.00"};
	public static final String[] NeomiDetails = {"Neomi","9111234562463","neomisony@gmail.com","1234567896","'1234567896","5,936.00"};
	public static final String[] ShebonDetails = {"Shebon","9111234562567","karen99@gmail.com","1234567895","CAB54321098","945.16"};
	public static final String[] ChandichenDetails = {"Chandichen","9111234562685","chandichen@gmail.com","ABC76543210","IFSC Code","1,500.01"};
	public static final String[] NikitaDetails = {"Nikita","9111234563473","nakki2000@gmail.com","1234567894","BCA65432109","2,603.48"};
	public static final String[] ChandniDetails = {"Chandni","9111234563567","chandnisuresh2000@gmail.com","1234567891","BCA98765432","10,582.70"};
	public static final String[] AlkaDetails = {"Alka","9111234563573","alku99@gmail.com","1234567897","BCA32109876","857.22"};
	public static final String[] AthulDetails = {"Athul","9111234563664","raju99@gmail.com","1234567899","ABC10987654","273.90"};
	public static final String[] AshwinDetails = {"Ashwin","9111234563672","ashwinpp@gmail.com","1234567898","CAB21098765","4,398.46"};
	public static final String[] MeenakshiDetails = {"Meenakshi","9111234568524","meenu99@gmail.com","1234567892","CAB87654321","1,359.56"};
	

	
}

	
	


   

        
        
        

                   

