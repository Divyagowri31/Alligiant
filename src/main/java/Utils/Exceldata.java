package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	static XSSFWorkbook wbook;
	static XSSFSheet sheet;
	static XSSFCell cell=null;
	public static String[][] getExcelData(String excel,String sheetname) {
		try {
			wbook = new XSSFWorkbook(excel);
			sheet = wbook.getSheet(sheetname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int Physicalnumberofrows = sheet.getPhysicalNumberOfRows();
		int lastcellnum = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("No.of rows: " + lastcellnum);
		String[][] data = new String[Physicalnumberofrows - 1][lastcellnum];
		for (int i = 1; i < Physicalnumberofrows; i++) {

			for (int j = 0; j < lastcellnum; j++) {
				 cell = sheet.getRow(i).getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i - 1][j] = value;
				
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}

}