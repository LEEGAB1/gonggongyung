package Data;

import com.spire.xls.*;
import java.nio.charset.Charset;

public class ExcelToCsv {
	   public static void main(String[] args) {

		   	String name = "yungdo_gu";
		   
	        //Create a workbook
	        Workbook workbook = new Workbook();

	        //Load a sample excel file
	        workbook.loadFromFile("D:\\gasstation\\" + name + ".xls");

	        //Get the first sheet
	        Worksheet sheet = workbook.getWorksheets().get(0);

	        //Save the document to CSV
	        sheet.saveToFile("output/" + name + ".csv", ",", Charset.forName("UTF-8"));
	        
	        
	        System.out.println("csv파일 생성완료");
	    }
}
