package com.crm.qa.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long Page_load_timeout =30;
	public static long implicit_wait=30;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
		}
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\AliNoor\\eclipse-workspace\\FREE_CRM_PRO_\\src\\main\\java\\com\\crm\\qa\\testdata\\DataDrivenFrameworkData.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		
		FileInputStream file = null;
		
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			book=WorkbookFactory.create(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
	
	
	}
	
	

