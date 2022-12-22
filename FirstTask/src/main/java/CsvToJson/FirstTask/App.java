package CsvToJson.FirstTask;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONWriter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;

public class App {
	 
	Map<String, Map<String, Map<String, String>>> jsonData = new HashMap<>(); 
	 
	public void readMethod() {

		String source = "source.csv";
		FileReader filereader;
		
		try {		
			
			 String prevCode = null;
			 int counter = 0;
			 filereader = new FileReader(source);
			 CSVReader csvReader = new CSVReader(filereader);
		     String[] nextRecord;
		     Map<String, Map<String, Map<String, String>>> jsonData = new HashMap<>(); 
		   	 List<String> headerList = new ArrayList<>();
		   	 
			while ((nextRecord = csvReader.readNext()) != null) {
				if (counter == 0) {
					counter++;
					headerList = Arrays.asList(nextRecord);
				} else {
					int length = nextRecord.length; 
					
					String currentCode = nextRecord[0]; 
					String platform = nextRecord[1];  
				
					Map<String, String> langMap = new HashMap<>();

					for (int i = 2; i < length; i++) {

						langMap.put(headerList.get(i), nextRecord[i]);
					}

					Map<String, Map<String, String>> platformMap = new HashMap<>();
					
					platformMap.put(platform, langMap);
					
					if (prevCode == null || !prevCode.equals(currentCode)) {
						prevCode = currentCode;
						jsonData.put(currentCode, platformMap);
						
					}
					else {
						
						Map<String, Map<String, String>> platformMapss = jsonData.get(currentCode);
						platformMapss.putAll(platformMap);
						jsonData.put(currentCode, platformMapss);
					}
				}
			}
			
			System.out.println(jsonData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String write() throws IOException {

		//JSONObject jsonObject = new JSONObject();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(jsonData);
	      System.out.println(prettyJson);
		try {
			
			File file = new File("JsonFile.json");
			file.createNewFile();
			
			FileWriter fileWriter = new FileWriter(file);
			System.out.println("Writing JSON object to file");
			fileWriter.write(prettyJson.toString());
			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) throws IOException {

     	App app = new App();
     	app.readMethod();
     	app.write();
  
     	
//		app.readMethod();
//		app.write();
		

	}

}
