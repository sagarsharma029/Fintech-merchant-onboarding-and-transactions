package utils;

import java.io.FileInputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {

	public static String getDataFromJson(String fileName, String keyPath) {
	    try {
	        JSONParser parser = new JSONParser();
	        JSONObject json = (JSONObject) parser.parse(
	            new FileReader("./src/test/resources/" + fileName + ".json")
	        );

	        String[] keys = keyPath.split("\\.");
	        JSONObject current = json;

	        for (int i = 0; i < keys.length - 1; i++) {
	            current = (JSONObject) current.get(keys[i]);
	        }

	        return (String) current.get(keys[keys.length - 1]);

	    } catch (Exception e) {
	        throw new RuntimeException("JSON read failed", e);
	    }
	}
	
	
	
	public static String getData(String filePath, String sheetName, int rowNum, int colNum) {
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);

			return cell.toString();

		} catch (Exception e) {
			throw new RuntimeException("Error reading Excel file", e);
		}
	}
}
