package Utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		ExcelUtils ex = new ExcelUtils("C:\\Users\\Shubham\\Workspace1\\seliJava\\Excel\\data.xlsx", "Sheet1");
		ex.getCellDataString(0, 0);
		ex.getCellDataNumeric(1, 1);
		ex.getRowCount();
	}

}
