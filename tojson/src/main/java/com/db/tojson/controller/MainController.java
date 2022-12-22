package com.db.tojson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.tojson.entity.JsonValues;
import com.db.tojson.service.MainService;
import com.db.tojson.service.ReadService;

@RestController
public class MainController {

	@Autowired
	private MainService mainService;
	
	@Autowired
	private ReadService readService;
	
	@GetMapping("/getjson")
	public List<JsonValues>findAllDbToJsons(){
		
	return mainService.getDbTOJson();
	}
	
	@GetMapping("/getJsonorder")
	public List<JsonValues>finJsonValues(){
		
	return mainService.jsonValues();
	}
	
	@GetMapping("/new")
	public Object readHome() {
		
		return readService.read();
	}
	
	
	
}
