package com.webservice.userdataservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.userdataservice.model.UserData;
import com.webservice.userdataservice.proxy.DatabaseServiceProxy;

@RestController
public class UserDataServiceController {

	Logger logger = LoggerFactory.getLogger(UserDataServiceController.class);

	@Autowired
	private DatabaseServiceProxy proxy;

	@PostMapping("/save")
	public ResponseEntity<UserData> saveUserData(@RequestBody UserData userData, HttpServletRequest request) {
		logger.info("Save request : {}", request);
		return new ResponseEntity<UserData>(proxy.saveUserData(userData), HttpStatus.OK);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<UserData> getUserData(@PathVariable("userId") int userId, HttpServletRequest request) {
		logger.info("getUserData request : {}", request.toString());
		return new ResponseEntity<UserData>(proxy.getUserData(userId), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserData>> getAllUser(HttpServletRequest request) {
		logger.info("getAllUser request : {}", request.toString());
		return new ResponseEntity<List<UserData>>(proxy.getAllUser(), HttpStatus.OK);
	}

}
