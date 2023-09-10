package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	ReadExcelData excel = new ReadExcelData();
	
	@DataProvider(name = "UserDP")
	public Object[][] dataProvider() throws IOException {
		
		//Object[][] data = {{"Yamaha r3"},{"Pulser 180"}};
		String filePath = System.getProperty("user.dir") + "\\Excel\\ExcelData.xlsx";
		String sheet = "UserData";
		
		Object[][] data =  excel.getAllExcelData(filePath, sheet);
		return data;
	}
	
	@DataProvider(name = "UserNameDP")
	public Object[]dataProvider1() throws IOException {
		
	
		String filePath = System.getProperty("user.dir") + "\\Excel\\ExcelData.xlsx";
		String sheet = "UserData";
		
		Object[] data =  excel.getExcelData(filePath, sheet);
		return data;
	}
	

}
