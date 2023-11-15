package Com.QA.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class CommonUtitlity {
	
	static Properties pro;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	public static List<String> GenerateData() {
		List<String> data=new ArrayList<String>();
		
		Faker fak=new Faker();
		String un=fak.internet().safeEmailAddress();
		String ps=fak.internet().password();
		
		data.add(un);
		data.add(ps);
		return data;
	}
	
	public static Properties init_DataProp() {
		try {
			FileInputStream file=new FileInputStream("src/main/resources/TestData/Reg.properties");
			pro=new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static String[][] get_Excel_Data() {
		String data[][]=null;
		
		try {
			FileInputStream file=new FileInputStream("src/main/resources/TestData/AddressData.xlsx");
	        
			wb=new XSSFWorkbook(file);
			sheet=wb.getSheet("Sheet1");
			int totalrows= sheet.getLastRowNum()+1;
			int totalCell= sheet.getRow(0).getLastCellNum();
			
			data=new String[totalrows-1][totalCell];
			
			for(int a=1;a<totalrows;a++) {
				for(int b=0;b<totalCell;b++) {
					data[a-1][b]=sheet.getRow(a).getCell(b).getStringCellValue();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	/*
	public static void main(String[] args) {
		String array[][]=CommonUtitlity.get_Excel_Data();

		for(int a=0;a<array.length;a++) {
			for(int b=0;b<array[a].length;b++) {
				System.out.print(array[a][b]+" ");
			}
			System.out.println();
		}
	}

	*/
}
