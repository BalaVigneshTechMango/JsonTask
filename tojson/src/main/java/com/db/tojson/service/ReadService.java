package com.db.tojson.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.tojson.entity.JsonValues;

@Service
public class ReadService {

	@Autowired
	private MainService mainService;

	public Object read() {
		 String prevCode = null;
		 String prevCode2 =null;
		 int counter = 0;
		 
		List<JsonValues> jsonValues=mainService.jsonValues();
	    Map<String, Map<String, Map<String, String>>> jsonData = new HashMap<>();
		   	   	 
	   	for ( JsonValues  i : jsonValues) {					
				    String currentCode = i.getCodes();
					String platform = i.getPlatfrom();  
                    String language=i.getLanguages();
				    String content=i.getContent();
				    
					Map<String, String> langMap = new HashMap<>();
					langMap.put(language, content);
					
				   //langMap.put(i.getLanguages(), i.getContent());  
	     
//					langMap.put("en-us", i.getContent());			
//   				langMap.put("en-In", i.getContent());
					 
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
		   	System.out.println(new JSONObject(jsonData));
		     return jsonData;
		
		
	}   	
	  
	  
	  
	  
}
