package com.first.app.serviceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.first.app.exception.TechnicalException;
import com.first.app.service.TimeConverterService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimeConverterServiceImpl implements TimeConverterService {
	
    public static final String  NUMSTEXT[]= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","thriteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Twenty One","Twenty two","Twenty three","Twenty four"};
	
	public static final String  ONESTEXT[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	
	public static final String TENSTEXT[]= {"","","Twenty","Thirty","Forty","Fifty"};
	
	public String finalHoursAndMinutes="";

	@Override
	public String convertTimeToString(String hourAndMinute) {
		
		try {
			
			log.info(hourAndMinute);
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm");
		
		int midnight_hour=0;
		LocalTime localTime=LocalTime.now();
		
		
		
		
		String split_hours_minutes[]=hourAndMinute.split(":",2);
		
		
		int hours=Integer.parseInt(split_hours_minutes[0]);
		
		int minutes=Integer.parseInt(split_hours_minutes[1]);
		
		LocalTime noon=LocalTime.NOON;
		
		String localNoon=dateTimeFormatter.format(noon);
		
		String split_noon[]=localNoon.split(":",2);
		
		int midnoon=Integer.parseInt(split_noon[0]);
		
		int midnoon_minutes=Integer.parseInt(split_noon[1]);
		
		LocalTime night=LocalTime.MIDNIGHT;
		
		System.out.println("night="+night);
		String localNight=dateTimeFormatter.format(night);
		
		String split_Night[]=localNight.split(":",2);
		
		int midnight=Integer.parseInt(split_Night[0]);
		System.out.println(midnight);
		int midnight_minutes=Integer.parseInt(split_noon[1]);
		
		if((hours>=1&&hours<=24)&&(minutes>=0&&minutes<=59)) {
			int TENSPLACE=minutes/10;
			int ONESPLACE=minutes%10;
			
			if(hours==24) {
			hours=midnight_hour;	
			}
			
			 finalHoursAndMinutes=("Its "+NUMSTEXT[hours]+":"+TENSTEXT[TENSPLACE]+" "+ONESTEXT[ONESPLACE]);
			if(hours==midnoon) {
				
			
				finalHoursAndMinutes=("Its Midday "+NUMSTEXT[hours]+":"+TENSTEXT[TENSPLACE]+" "+ONESTEXT[ONESPLACE]);
			}
			else if(hours==midnight)
			{
				finalHoursAndMinutes=("Its Midnight");
			}
			 
		}
		
		}
		catch(Exception e) {
			log.error("Unexpected error while converting time to string format "+e);
			
			throw new TechnicalException("Unexpected Error occured ");
			
		}
		
		return finalHoursAndMinutes;

		
	}
	

}
