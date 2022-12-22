package com.db.retrieve.service.implementation;

import java.security.PublicKey;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.db.retrieve.controller.MainController;
import com.db.retrieve.entity.ExampleFiles;

@Service
public class ReadService {
	@Autowired
	private CustomerImplementation customerInterface;
	

	public Object read() {
		
		//mainController.homepage();
		
		 String prevCode = null;
		 int counter = 0;
        //String [] nextRecord; 
        List<Map>objExampleFiles=customerInterface.getExampleFiles();
        
        System.out.println(objExampleFiles);
	    
        Map<String, Map<String, Map<String, String>>> jsonData = new HashMap<>(); 
	   	 List<ExampleFiles> headerList = new ArrayList<>();
   	 
//	   	 
//	   	for ( ExampleFiles  i : objExampleFiles) {
//	   		
//	   		
//				int length = 4;
//				
//				String currentCode = Integer.toString(i.getCodes());
//				
//				String platform = i.getPlatfrom();  
//			
//				Map<String, String> langMap = new HashMap<>();
//        
//					langMap.put("en-US", i.getEnUs());				
//					langMap.put("en-IN", i.getEnIN());
//					
//				Map<String, Map<String, String>> platformMap = new HashMap<>();
//				
//				platformMap.put(platform, langMap);
//				
//				if (prevCode == null || !prevCode.equals(currentCode)) {
//					prevCode = currentCode;
//					jsonData.put(currentCode, platformMap);
//					
//				}
//				else {
//					
//					Map<String, Map<String, String>> platformMapss = jsonData.get(currentCode);
//					platformMapss.putAll(platformMap);
//					jsonData.put(currentCode, platformMapss);
//				}
	//		}
	   	System.out.println(new JSONObject(jsonData));
	   		return jsonData;
	   	
	   	}
	
  
	}


