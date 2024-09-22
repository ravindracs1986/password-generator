/**
 * 
 */
package com.password.generator.password.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.password.generator.password.service.GeneratePasswordService;

/**
 * 
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/generate")
public class GeneratePasswordController {
	
	@Autowired
	GeneratePasswordService service;
	
	Logger logger = LoggerFactory.getLogger(GeneratePasswordController.class);
	
	@GetMapping("/length")
	public ResponseEntity<String> generatePasswordWithlength(@RequestParam(defaultValue = "6") String passLength) {
		String status = "fail";
		try {
			int len=Integer.parseInt(passLength);
			
			logger.info("incoming passLength-->"+passLength);
			
			if (len!=0) {
				status=service.generatepasswithlength(len);
			}
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lengthWithName")
	public ResponseEntity<String> generatePasswordWithlengthandName(@RequestParam(required = true) String passLength,@RequestParam(required = true)String name) {
		String status = "fail";
		try {
			logger.info("incoming passLength-->"+passLength +",name->"+name);
			int len=Integer.parseInt(passLength);
			if (len!=0 && !StringUtils.isEmpty(name)) {
				status=service.generatepasswithlengthAndName(len,name);
			}
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
