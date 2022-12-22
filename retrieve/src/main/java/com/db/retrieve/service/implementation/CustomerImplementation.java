package com.db.retrieve.service.implementation;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.retrieve.entity.ExampleFiles;
import com.db.retrieve.repository.ExampleRepository;

@Service
public class CustomerImplementation   {

	@Autowired
	private ExampleRepository exampleRepository;
	
	
//	public void saveExm(ExampleFiles exampleFiles) {
//		
//		exampleRepository.save(exampleFiles);
//	}

	public List<Map> getExampleFiles() {
		return exampleRepository.findAll();
	}

	
	
	

	
	
	
}
