package jdbcconnection;

public class Test1 {
public static void main(String[] args) {
	
	
	ExcelUtils.openExcelFile("test2.xlsx", "Sheet1");
	System.out.println(ExcelUtils.getCellData(6, 8));
	System.out.println(ExcelUtils.getCellData(6, 9));
	System.out.println(ExcelUtils.getCellData(6, 10));
	
	System.out.println(ExcelUtils.getUsedRowsCount());
//	while still rows exist then iterate thru and read xml and db based on xmlpath and db locaiton
	
	ExcelUtils.setCellData("test", 1, 1);
	
	ExcelUtils.setCellData("testXML", 6, 14);
	ExcelUtils.setCellData("testDB", 6, 15);
	
	
	
}
}
