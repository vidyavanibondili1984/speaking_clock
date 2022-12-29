package com.first.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.app.service.TimeConverterService;
import com.first.app.serviceImpl.TimeConverterServiceImpl;

@SpringBootTest
class SpeakingClockApplicationTests {
	
	TimeConverterService timeService=new TimeConverterServiceImpl();

	@Test
	void contextLoads() {
		
		String result=timeService.convertTimeToString("22:40");
		Assertions.assertEquals("Its Twenty two:Forty ",result);
		String noon=timeService.convertTimeToString("12:33");
		Assertions.assertEquals("Its Midday Twelve:Thirty Three", noon);
		String night=timeService.convertTimeToString("24:33");
		Assertions.assertEquals("Its Midnight", night);
	}

}
