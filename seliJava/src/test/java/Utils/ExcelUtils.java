package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook wb;
	static XSSFSheet s;
	static int rc=0;
	
	public ExcelUtils(String excelPath,String SheetName) {
		try {
		wb = new XSSFWorkbook(excelPath);
		s = wb.getSheet(SheetName);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	public static int getRowCount() {
		try {
			
			rc = s.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rc);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rc;
	}
	
	public static int getColCount() {
		try {
			
			rc = s.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column Count: "+rc);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rc;
	}

	public static String getCellDataString(int rno,int colno){
		String celldata=null;
		try {
			
			celldata = s.getRow(rno).getCell(colno).getStringCellValue();
//			System.out.println(celldata);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;
	}


	public static void getCellDataNumeric(int rno,int colno){
		try {
			
			System.out.print(s.getRow(rno).getCell(colno).getStringCellValue());
			System.out.println();
		}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
		}


		public static void main(String[] args) {
					}
	}
