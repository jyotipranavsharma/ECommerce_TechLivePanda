package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public static void readConfig(String excelPath) {
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String readData( String sheetName,int row, int column) {
        readConfig("config/TestData.xlsx");
        DataFormatter df = new DataFormatter();
		sheet = wb.getSheet(sheetName);
		String data = df.formatCellValue(sheet.getRow(row).getCell(column));
		data = data.trim();
//		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	/*public static void main(String[] args) {
		System.out.println("hello");
		ExcelConfig obj = new ExcelConfig("config/TestData.xlsx");		
		System.out.println("msg "+obj.readData("TestCase-2" ,1, 3 ));
	}*/

}
