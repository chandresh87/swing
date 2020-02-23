package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProcessFileImpl implements ProcessFile {

	@Override
	public void process(String fileName) throws IOException {
		File file = new File(fileName);
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		Workbook addCatalog = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name
		if (fileExtensionName.equals(".xsls")) {
			// If it is .xls file then create object of HSSFWorkbook class
			addCatalog = new HSSFWorkbook(fis);
		} else if (fileExtensionName.equals(".xlsx")) {
			// If it is .xlsx file then create object of XSSFWorkbook class
			addCatalog = new XSSFWorkbook(fis);
		}

		// Read Sheet

		HashMap<String, Integer> coloumnNameSheet2 = new HashMap<String, Integer>();
		HashMap<String, Integer> coloumnNameSheet1 = new HashMap<String, Integer>();

		Sheet sheet1 = addCatalog.getSheetAt(0);
		Sheet sheet2 = addCatalog.getSheetAt(1);

		getColumn(coloumnNameSheet1, sheet1, 0);
		getColumn(coloumnNameSheet2, sheet2, 1);
		
		//compare column
		Map<String, Integer> commonColumn= compareColums(coloumnNameSheet1,coloumnNameSheet2);
		System.out.println("common coloumn");
		commonColumn.keySet().stream().forEach(col -> System.out.println(col));
		
		System.out.println("col name is "+CellReference.convertNumToColString(1));

	}

	private void getColumn(Map<String, Integer> coloumnNameSheet, Sheet sheet, int romNum) {

		Row row = sheet.getRow(romNum);
		
		System.out.println("Sheet Name is ****" + sheet.getSheetName());
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);

		
			System.out.println("sheet values are" + cell.getColumnIndex() + "" + cell.getStringCellValue());
			// Add all the cell values of a particular row
			coloumnNameSheet.put(cell.getStringCellValue(), cell.getColumnIndex());
			
			
			CellReference.convertNumToColString(cell.getColumnIndex());
		}
	}
	
	private Map<String, Integer> compareColums(Map<String, Integer> coloumnNameSheet1,Map<String, Integer> coloumnNameSheet2)
	{
		Map<String, Integer> commonMap = coloumnNameSheet1.entrySet().stream()
		        .filter(x -> coloumnNameSheet2.containsKey(x.getKey()))
		        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
		return commonMap;
	}
	
	private void write()
	{
		//for (int i = 1;j=3; i < row.getLastCellNum(); i++;j++) {
		
		//Sheet 2 Row index= 3;
		//Read sheet 1 
		// row by row 
		// get cell indexx
		//Match cell index with value array of common hash map List<String> result2 = new ArrayList(map.values());  using contains
		// Write in sheet 2
		
		 // Specific row number 
        //Row row = sheet.createRow(j);   /// check row already exssit
  
        // Specific cell number 
       // Cell cell = row.createCell(index of colum); 
  
        // putting value at specific position 
       // cell.setCellValue("Geeks"); 
		
		
	}

}
