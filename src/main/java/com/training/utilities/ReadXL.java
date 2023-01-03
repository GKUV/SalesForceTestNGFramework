package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
	
	static XSSFWorkbook ExcelWbook;
	static XSSFSheet ExcelWSheet;
	static XSSFRow Row;
	static XSSFCell Cell;
	
	public static void main(String[] args) throws IOException {
		
		String FilePath = "C:\\Users\\guruk\\OneDrive\\Desktop\\Java Screenshots\\TestNG\\TestNG-Salesforce framework\\InputData.xlsx";
		FileInputStream ExcelFile = new FileInputStream(FilePath);
		
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWbook.getSheet("Login");
//		int totalRows = ExcelWSheet.getLastRowNum();
		int totalRows = 2;
		int totalCols = 3;
		
		for (int i=1;i <= totalRows;i++) {
			for(int j = 1; j <= totalCols ; j++) {
			//	System.out.print(ExcelWSheet.getRow(i).getCell(j));
				Cell=ExcelWSheet.getRow(i).getCell(j);
				System.out.print(Cell);
		}
			System.out.print("\n");
		}
		
		
		
		
	}

}
