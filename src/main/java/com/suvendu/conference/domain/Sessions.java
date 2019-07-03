package com.suvendu.conference.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sessions {
	
	private Map<String, Talk> talks = new HashMap<>();
    
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	public static final DateTimeFormatter TIME_FORMAT = new DateTimeFormatterBuilder().appendPattern("hh:mm a").toFormatter();
	
	public Sessions(Integer startTime , Integer endTime) {
		this.startTime= LocalTime.of(startTime, 0);
		this.endTime = LocalTime.of(endTime, 0);
		
	}
	
	public Boolean addTalk(Talk talk) {
		LocalTime nextSession = startTime.plusMinutes(talk.getDuration());
		if(nextSession.isAfter(endTime)) {
			return false;
		}
		talk.setStartTime(TIME_FORMAT.format(this.startTime));
		talks.put(TIME_FORMAT.format(this.startTime), talk);
		this.startTime = nextSession;
		return true;
	}

	public Talk getTalkByTime(String time) {
		return talks.get(time);
	}

	public List<Talk> getAllTalks() {
		return new ArrayList<>(talks.values());
	}
	
}
