package com.db.tojson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.db.tojson.entity.JsonValues;
import com.db.tojson.repository.DbToJsonRepository;

@Service
public class MainService {
	@Autowired
	private DbToJsonRepository dbToJsonRepository;

//	public List<JsonValues> jsonValues=dbToJsonRepository.findAll(Sort.by("platfrom").ascending());

	public List<JsonValues> getDbTOJson() {
		
		return dbToJsonRepository.findAll();
	}
	
	public List<JsonValues> jsonValues(){
		
		return dbToJsonRepository.findAll(Sort.by("codes","platfrom").ascending());
	}
	
}
