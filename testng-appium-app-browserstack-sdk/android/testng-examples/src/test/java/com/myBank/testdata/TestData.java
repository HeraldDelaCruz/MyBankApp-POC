package com.myBank.testdata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;


public class TestData {
	
	public String excelTestData(int sheet,int row,int cell) throws Exception {
		
        String excelpath = "C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\testng-appium-myBank-browserstack-sdk\\"
        		+ "testng-appium-app-browserstack-sdk\\android\\testng-examples\\src\\test\\java\\com\\myBank\\testdata\\testdata.xlsx";
        //locate file
        FileInputStream fis = new FileInputStream(excelpath);
        
        //get data
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        
		return workbook.getSheetAt(sheet).getRow(row).getCell(cell).getStringCellValue(); 
  
	}    	
	
	
	
}
        
        
        
		/*			
		 * //get cell data //Cyril XSSFCell cyrilName =
		 * workbook.getSheetAt(0).getRow(1).getCell(0); XSSFCell cyrilAccountNum =
		 * workbook.getSheetAt(0).getRow(1).getCell(1); XSSFCell cyrilEmail =
		 * workbook.getSheetAt(0).getRow(1).getCell(2); XSSFCell cyrilMobile =
		 * workbook.getSheetAt(0).getRow(1).getCell(3); XSSFCell cyrilIfsc =
		 * workbook.getSheetAt(0).getRow(1).getCell(4); XSSFCell cyrilBal =
		 * workbook.getSheetAt(0).getRow(1).getCell(5);
		 * 
		 * //Neomi XSSFCell neomiName = workbook.getSheetAt(0).getRow(2).getCell(0);
		 * XSSFCell neomiAccountNum = workbook.getSheetAt(0).getRow(2).getCell(1);
		 * XSSFCell neomiEmail = workbook.getSheetAt(0).getRow(2).getCell(2); XSSFCell
		 * neomiMobile = workbook.getSheetAt(0).getRow(2).getCell(3); XSSFCell neomiIfsc
		 * = workbook.getSheetAt(0).getRow(2).getCell(4); XSSFCell neomiBal =
		 * workbook.getSheetAt(0).getRow(2).getCell(5);
		 * 
		 * //Shebon XSSFCell shebonName = workbook.getSheetAt(0).getRow(3).getCell(0);
		 * XSSFCell shebonAccountNum = workbook.getSheetAt(0).getRow(3).getCell(1);
		 * XSSFCell shebonEmail = workbook.getSheetAt(0).getRow(3).getCell(2); XSSFCell
		 * shebonMobile = workbook.getSheetAt(0).getRow(3).getCell(3); XSSFCell
		 * shebonIfsc = workbook.getSheetAt(0).getRow(3).getCell(4); XSSFCell shebonBal
		 * = workbook.getSheetAt(0).getRow(3).getCell(5);
		 * 
		 * //Chandichen XSSFCell chandichenName =
		 * workbook.getSheetAt(0).getRow(4).getCell(0); XSSFCell chandichenAccountNum =
		 * workbook.getSheetAt(0).getRow(4).getCell(1); XSSFCell chandichenEmail =
		 * workbook.getSheetAt(0).getRow(4).getCell(2); XSSFCell chandichenMobile =
		 * workbook.getSheetAt(0).getRow(4).getCell(3); XSSFCell chandichenIfsc =
		 * workbook.getSheetAt(0).getRow(4).getCell(4); XSSFCell chandichenBal =
		 * workbook.getSheetAt(0).getRow(4).getCell(5);
		 * 
		 * //Nikita XSSFCell nikitaName = workbook.getSheetAt(0).getRow(5).getCell(0);
		 * XSSFCell nikitaAccountNum = workbook.getSheetAt(0).getRow(5).getCell(1);
		 * XSSFCell nikitaEmail = workbook.getSheetAt(0).getRow(5).getCell(2); XSSFCell
		 * nikitaMobile = workbook.getSheetAt(0).getRow(5).getCell(3); XSSFCell
		 * nikitaIfsc = workbook.getSheetAt(0).getRow(5).getCell(4); XSSFCell nikitaBal
		 * = workbook.getSheetAt(0).getRow(5).getCell(5);
		 * 
		 * //Chandni XSSFCell chandniName = workbook.getSheetAt(0).getRow(6).getCell(0);
		 * XSSFCell chandniAccountNum = workbook.getSheetAt(0).getRow(6).getCell(1);
		 * XSSFCell chandniEmail = workbook.getSheetAt(0).getRow(6).getCell(2); XSSFCell
		 * chandniMobile = workbook.getSheetAt(0).getRow(6).getCell(3); XSSFCell
		 * chandniIfsc = workbook.getSheetAt(0).getRow(6).getCell(4); XSSFCell
		 * chandniBal = workbook.getSheetAt(0).getRow(6).getCell(5);
		 * 
		 * //Alka XSSFCell alkaName = workbook.getSheetAt(0).getRow(7).getCell(0);
		 * XSSFCell alkaAccountNum = workbook.getSheetAt(0).getRow(7).getCell(1);
		 * XSSFCell alkaEmail = workbook.getSheetAt(0).getRow(7).getCell(2); XSSFCell
		 * alkaMobile = workbook.getSheetAt(0).getRow(7).getCell(3); XSSFCell alkaIfsc =
		 * workbook.getSheetAt(0).getRow(7).getCell(4); XSSFCell alkaBal =
		 * workbook.getSheetAt(0).getRow(7).getCell(5);
		 * 
		 * //Athul XSSFCell athulName = workbook.getSheetAt(0).getRow(8).getCell(0);
		 * XSSFCell athulAccountNum = workbook.getSheetAt(0).getRow(8).getCell(1);
		 * XSSFCell athulEmail = workbook.getSheetAt(0).getRow(8).getCell(2); XSSFCell
		 * athulMobile = workbook.getSheetAt(0).getRow(8).getCell(3); XSSFCell athulIfsc
		 * = workbook.getSheetAt(0).getRow(8).getCell(4); XSSFCell athulBal =
		 * workbook.getSheetAt(0).getRow(8).getCell(5);
		 * 
		 * //Ashwin XSSFCell ashwinName = workbook.getSheetAt(0).getRow(9).getCell(0);
		 * XSSFCell ashwinAccountNum = workbook.getSheetAt(0).getRow(9).getCell(1);
		 * XSSFCell ashwinEmail = workbook.getSheetAt(0).getRow(9).getCell(2); XSSFCell
		 * ashwinMobile = workbook.getSheetAt(0).getRow(9).getCell(3); XSSFCell
		 * ashwinIfsc = workbook.getSheetAt(0).getRow(9).getCell(4); XSSFCell ashwinBal
		 * = workbook.getSheetAt(0).getRow(9).getCell(5);
		 * 
		 * //Meenakshi XSSFCell meenakshiName =
		 * workbook.getSheetAt(0).getRow(9).getCell(0); XSSFCell meenakshiAccountNum =
		 * workbook.getSheetAt(0).getRow(9).getCell(1); XSSFCell meenakshiEmail =
		 * workbook.getSheetAt(0).getRow(9).getCell(2); XSSFCell meenakshiMobile =
		 * workbook.getSheetAt(0).getRow(9).getCell(3); XSSFCell meenakshiIfsc =
		 * workbook.getSheetAt(0).getRow(9).getCell(4); XSSFCell meenakshiBal =
		 * workbook.getSheetAt(0).getRow(9).getCell(5);
		 * 
		 * //Amount XSSFCell amount100 = workbook.getSheetAt(1).getRow(1).getCell(0);
		 * XSSFCell amount200 = workbook.getSheetAt(1).getRow(2).getCell(0); XSSFCell
		 * amount300 = workbook.getSheetAt(1).getRow(3).getCell(0); XSSFCell amount400 =
		 * workbook.getSheetAt(1).getRow(4).getCell(0); XSSFCell amount500 =
		 * workbook.getSheetAt(1).getRow(5).getCell(0); XSSFCell amount600 =
		 * workbook.getSheetAt(1).getRow(6).getCell(0); XSSFCell amount700 =
		 * workbook.getSheetAt(1).getRow(7).getCell(0); XSSFCell amount800 =
		 * workbook.getSheetAt(1).getRow(8).getCell(0); XSSFCell amount900 =
		 * workbook.getSheetAt(1).getRow(9).getCell(0); XSSFCell amount1000 =
		 * workbook.getSheetAt(1).getRow(10).getCell(0);
		 */

		//public void getdata() throws Exception {
		//String d = excelTestData(0,1,1);
		//System.out.println(d);
		//}
                   

