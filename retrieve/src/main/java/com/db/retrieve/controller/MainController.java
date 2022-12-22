package com.db.retrieve.controller;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.db.retrieve.entity.ExampleFiles;
import com.db.retrieve.service.implementation.CustomerImplementation;
import com.db.retrieve.service.implementation.ReadService;


@RestController
public class MainController {

	@Autowired
	private CustomerImplementation customerInterface;
	
	@Autowired
	private ReadService readService;
	
//	@PostMapping("/addExample")
//	public String addCustomer(@RequestBody ExampleFiles exampleFiles) {
//		
//		customerInterface.saveExm(exampleFiles);
//		
//		return "Added successfully";
//	}
//	@GetMapping("/getCustomer")
//	public List<ExampleFiles>findAllCustomers(){
//		
//		return customerInterface.getExampleFiles();
//	}
	
	@GetMapping("/bv")
	public Object homepage() {
		
	return	readService.read();
//	JSONObject jsonObject=new JSONObject();
//	
//	jsonObject.append("abc", "bala");
//	
//	return "abc";
//	
	}
	
	
	
}
