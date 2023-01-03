package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook ExcelWbook;
	static XSSFSheet ExcelWSheet;
	static XSSFRow Row;
	static XSSFCell Cell;
	
	
	public static Object[][] getTableArray(String filePath,String SheetName,int testcaseNo) throws IOException {
		int ci, cj;
		String[][] tabArray = null;
		FileInputStream ExcelFile = new FileInputStream(filePath);
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWbook.getSheet(SheetName);
		int totalRows=1;
		int totalCols=2;
		tabArray = new String[totalRows][totalCols];
		ci=0;
		cj=0;
		for(int j=1;j<=totalCols;j++,cj++) {
			tabArray[ci][cj]=getCellData(testcaseNo,j);
			System.out.println(tabArray[ci][cj]+" ");
		}
		return tabArray;
	}


	private static String getCellData(int RowNum, int ColNum) {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();		
		return CellData;
	}
	
}
