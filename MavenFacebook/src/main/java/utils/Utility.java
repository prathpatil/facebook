package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
 public int testID;
	public static void capturescreenshot(int testID , WebDriver driver) throws IOException
	{
		
		SimpleDateFormat date=new SimpleDateFormat("dd.MM.yyyy. HH.mm.SS");
		Date d= new Date();
		String a=date.format(d);
		
		TakesScreenshot s=(TakesScreenshot)driver;
		
		File source=s.getScreenshotAs(OutputType.FILE);
		File store=new File("C:\\Users\\Smart\\sellineum ss\\testId-"+testID+" "+a+".jpeg");
		
		FileHandler.copy(source, store);
		
		
	}
	
	public static String getDataFromExelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
 
		 String cellvalue="";
         File file=new File("C:\\Users\\Smart\\Desktop\\Test class.xlsx");
		 Workbook book=WorkbookFactory.create(file);
		 Cell value=book.getSheet("Document").getRow(row).getCell(cell);
		 
		try 
		{
			cellvalue=value.getStringCellValue();
			
		}
		catch(IllegalStateException e) {
			double numcellvalue=value.getNumericCellValue();
			//Double to String convert
			//double d = 123.45d;
			cellvalue = numcellvalue+""; // str is '123.45'
		}
		
		 return cellvalue;
	
	}
}
