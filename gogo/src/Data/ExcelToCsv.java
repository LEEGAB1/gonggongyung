package Data;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.spire.xls.*;

public class ExcelToCsv {
	   public static void main(String[] args) {
		   
		   List<String>fileName = new ArrayList<>();
		      fileName.add("gangseo_gu_gas_station");
		      fileName.add("geumjeong_gu_gas_station");
		      fileName.add("gijang_gu_gas_station");
		      fileName.add("nam_gu_gas_station");
		      fileName.add("dong_gu_gas_station");
		      fileName.add("dongrae_gu_gas_station");
		      fileName.add("jin_gu_gas_station");
		      fileName.add("buk_gu_gas_station");
		      fileName.add("sasang_gu_gas_station");
		      fileName.add("saha_gu_gas_station");
		      fileName.add("seo_gu_gas_station");
		      fileName.add("suyung_gu_gas_station");
		      fileName.add("yeonje_gu_gas_station");
		      fileName.add("yungdo_gu_gas_station");
		      fileName.add("jung_gu_gas_station");
		      fileName.add("haeundae_gu_gas_station");
		   
		   for(int i =0;i<fileName.size();i++) {
	        //Create a workbook
	        Workbook workbook = new Workbook();

	        //Load a sample excel file
	        workbook.loadFromFile("D:\\gasstation\\" + fileName.get(i) + ".xls");

	        //Get the first sheet
	        Worksheet sheet = workbook.getWorksheets().get(0);

	        //Save the document to CSV
	        sheet.saveToFile("output/" + fileName.get(i) + ".csv", ",", Charset.forName("UTF-8"));
	        
	        
	         System.out.println(fileName.get(i) +"csv파일 생성완료");
		   }
	    }
}
