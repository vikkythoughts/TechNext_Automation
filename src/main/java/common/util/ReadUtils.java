package common.util;

import java.io.File;
import java.io.FileReader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadUtils {
	
	// Excel file path
		private static String filePath = Utilities.dir() + "/src/test/resources/TestData/ExcelFile/DataFile.xls";
		public static FileReader fileRead;
		
		
		static HSSFWorkbook workbook;
		static HSSFSheet sheet;
		static DataFormatter formatter;

		// This function is used to fetch the particular row and cell data
		public static String getData(String sheetName, int rowNum, int cellNum) {

			String retVal = null;
			try {
				Workbook wb = WorkbookFactory.create(new File(filePath));
				try {
					Sheet s = wb.getSheet(sheetName);
					Row row = s.getRow(rowNum);
					Cell cell = row.getCell(cellNum);
					DataFormatter dataFormatter = new DataFormatter();
					retVal = dataFormatter.formatCellValue(cell);
					wb.close();
					
				} catch (Exception e) {
				e.printStackTrace();
				wb.close();
				}
			}catch(Exception f) {
			f.printStackTrace();
			}
			return retVal;
		}

}
