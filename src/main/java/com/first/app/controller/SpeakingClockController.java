package com.first.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.app.service.TimeConverterService;

@RestController
public class SpeakingClockController {
	
	@Autowired
	TimeConverterService timeConverterService;
	
	@GetMapping(value="/welcome")
	public String welcomeString() {
		System.out.println("server calling");
		return "welcome to time converter app";
	}
	
	@GetMapping(value="/time/{hoursAndMinute}")
	public ResponseEntity<String> getTimeInWords(@RequestParam(name="hoursAndMinute" ,required=true)String hoursAndMinutes)
	{
		System.out.println(hoursAndMinutes);
		String tms= timeConverterService.convertTimeToString(hoursAndMinutes);
		System.out.println("tms="+tms);
		
		return new ResponseEntity<>(timeConverterService.convertTimeToString(hoursAndMinutes),HttpStatus.OK);
		
	}

}
