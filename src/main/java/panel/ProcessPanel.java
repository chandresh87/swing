package panel;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
public class ProcessPanel extends JPanel {

	private JButton processing;
	private JButton save;
	private String filename;
	
	public ProcessPanel(){
		this.setLayout(new GridLayout(2,3));
		
		
		}
	
	private void createProcess()throws IOException, InvalidFormatException{
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.showOpenDialog(jfc);
		
		filename= jfc.getSelectedFile().getAbsolutePath();
		
		
		
		File file = new File(filename);
		 //Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);
		Workbook AddCatalog = null; 
		String fileExtensionName = filename.substring(filename.indexOf("."));
		
	//Find the file extension by splitting file name in substring  and getting only extension name
	if(fileExtensionName.equals(".xsls")){
	        //If it is .xls file then create object of HSSFWorkbook class
	        AddCatalog = new HSSFWorkbook(fis);
	    }
	 else if(fileExtensionName.equals(".xlsx")){
	        //If it is .xlsx file then create object of XSSFWorkbook class
	        AddCatalog = new XSSFWorkbook(fis);
	    }
	 //Read sheet inside the workbook by its name
    Sheet AddCatalogSheet = AddCatalog.getSheet(getName());
   Row row = AddCatalogSheet.getRow(1);
   HashMap<Integer,String> hm = new HashMap<Integer,String>();
   for(int i=0; i<row.getLastCellNum();i++){
	   Cell cell = row.getCell(i);
	  
       // Add all the cell values of a particular row
       hm.put( cell.getColumnIndex(),cell.getStringCellValue());
       }
	   
   }
		
	}
	
	
	
	

