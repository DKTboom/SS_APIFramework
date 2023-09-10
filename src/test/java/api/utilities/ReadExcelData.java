package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	DataFormatter format = new DataFormatter();
	
	public Object[][] getAllExcelData(String fileName, String sheetName) throws IOException {
		
		
		FileInputStream inputStream = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getLastCellNum();
	    
	    Object eData[][] = new String[rowCount-1][colCount];
	    
	    for(int i=0;i<rowCount-1;i++) {
	    	XSSFRow row = sheet.getRow(i+1);
	    	
	    	for(int j=0;j<colCount;j++) {
	    		
	    		XSSFCell cell = row.getCell(j);
	    		eData[i][j]=format.formatCellValue(cell);
	    	}
	    }
	    workbook.close();
		return eData;
	}
	
	public Object[] getExcelData(String fileName, String sheetName) throws IOException {
		
		
		FileInputStream inputStream = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    
	    Object userName[] = new String[rowCount-1];
	    
	    for(int i=0;i<rowCount-1;i++) {
	    	XSSFRow row = sheet.getRow(i+1);
	    	XSSFCell cell = row.getCell(1);
	    	userName[i]=format.formatCellValue(cell);
	    	
	    }
	    workbook.close();
		return userName;
	}

}
