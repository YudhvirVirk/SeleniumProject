package com.company.util;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {
	private FileInputStream filein;		//file path
	private HSSFWorkbook workbook;		//workbook
	private HSSFSheet sheet;			//sheetNo./sheetname
	private HSSFCell cell;				//row and column--->cell
	private DataFormatter formatter;
	
//	private FileInputStream filein;		//file path
//	private XSSFWorkbook workbook;		//workbook
//	private XSSFSheet sheet;			//sheetNo./sheetname
//	private XSSFCell cell;				//row and column--->cell
	
	public void setExcel( String filepath, String sheetname) throws Exception{
		filein = new FileInputStream(filepath);
//		workbook = new XSSFWorkbook(filein);
		workbook = new HSSFWorkbook(filein);
		sheet = workbook.getSheet(sheetname);
	}
	
	public String getCellValue(int row, int column) {
		cell = sheet.getRow(row).getCell(column);		//never works for other then text
		formatter = new DataFormatter();
	//	System.out.println(sheet.getRow(row).getCell(column).CELL_TYPE_BLANK);
//		return cell.getStringCellValue();
		return formatter.formatCellValue(cell);
	}
	public boolean isCellEmpty(int row, int column) {
		try {
			cell = sheet.getRow(row).getCell(column);
			return false;
		}catch(Exception e){
			return true;
		}
	}
}
