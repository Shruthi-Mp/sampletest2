package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib {

	public String fetchDataformProperty(String key) throws IOException
	{	
		FileInputStream file = new FileInputStream("./src/main/resources/CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(file);
		String value = pobj.getProperty(key);
		return value;
	}
	public String fetchDatafromExcel(String sheetname, int RowNum, int CelNum) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/main/resources/TestData2.xlsx");
		//FileInputStream file = new FileInputStream("C:\\Users\\52002237\\Desktop\\TestData.xslx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row ro = sh.getRow(RowNum);
		Cell cel = ro.getCell(CelNum);
		String value= cel.getStringCellValue();
		return value;
	}
	public double fetchDatafromExcelDouble(String sheetname, int RowNum, int CelNum) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/main/resources/TestData2.xlsx");
		//FileInputStream file = new FileInputStream("C:\\Users\\52002237\\Desktop\\TestData.xslx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetname);
		Row ro = sh.getRow(RowNum);
		Cell cel = ro.getCell(CelNum);
		double value=cel.getNumericCellValue();
		return value;
	}
	public void SetDatainExcel(String sheetname, int RowNum, int CelNum, String value) throws EncryptedDocumentException, IOException
	{
		//Load external file(here Excel) into java
		FileInputStream file = new FileInputStream("./src/main/resources/TestData2.xlsx");
		//open excel and create sheet 
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.createSheet(sheetname);
		Row ro = sh.createRow(RowNum);
		Cell cel = ro.createCell(CelNum);
		cel.setCellValue(value);
		
		//write output to external file or connect java file to external(excel) file
		FileOutputStream out = new FileOutputStream("./src/main/resources/TestData2.xlsx");
		book.write(out);
		System.out.println("data updated successfully");
	}
}
