package com.suvendu.conference;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.suvendu.conference.domain.Talk;
import com.suvendu.conference.domain.Track;
import com.suvendu.conference.exception.ConferenceException;

/**
	 * Writing Fast Tests Against Enterprise Rails 60min
		Overdoing it in Python 45min
		Lua for the Masses 30min
		Ruby Errors from Mismatched Gem Versions 45min
		Common Ruby Errors 45min
		Rails for Python Developers lightning
		Communicating Over Distance 60min
		Accounting-Driven Development 45min
		Woah 30min
		Sit Down and Write 30min
		Pair Programming vs Noise 45min
		Rails Magic 60min
		Ruby on Rails: Why We Should Move On 60min
		Clojure Ate Scala (on my project) 45min
		Programming in the Boondocks of Seattle 30min
		Ruby vs. Clojure for Back-End Development 30min
		Ruby on Rails Legacy App Maintenance 60min
		A World Without HackerNews 30min
		User Interface CSS in Rails Apps 30min


	 */

public class TrackTest {
	
	private Track track;
	

	@Before
	public void setUp() {
		track = new Track();
	}
	
	@Test
	public void trackShouldAbletoAddMorningTalks() {
		addMorningSessions();
		assertEquals(4, track.getMorningSession().getAllTalks().size());
		track.getMorningSession().getAllTalks().forEach(s -> System.out.println(s));
		
		
	}
	
	@Test
	public void trackShouldAbletoAddAfterNoonTalk() {
		addMorningSessions();
		addAfternoonSessions();
		assertEquals(4, track.getAfterNoonSession().getAllTalks().size());
		track.getAfterNoonSession().getAllTalks().forEach(s -> System.out.println(s));
		
	}
	
	@Test(expected=ConferenceException.class)
	public void trackShouldBeFullTrack() {
		addMorningSessions();
		addAfternoonSessions();
		track.addTalk(new Talk("Communicating Over Distance 60min"));
		track.addTalk(new Talk("Communicating Over Distance 60min"));
		track.getMorningSession().getAllTalks().forEach(s -> System.out.println(s));
		track.getAfterNoonSession().getAllTalks().forEach(s -> System.out.println(s));
		track.getNetworkingSession().getAllTalks().forEach(s -> System.out.println(s));
		
	
	}

	private void addAfternoonSessions() {
		track.addTalk(new Talk("Common Ruby Errors 45min"));
		track.addTalk(new Talk("Rails for Python Developers lightning"));
		track.addTalk(new Talk("Communicating Over Distance 60min"));
		track.addTalk(new Talk("Accounting-Driven Development 45min"));
	}

	private void addMorningSessions() {
		track.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		track.addTalk(new Talk("Overdoing it in Python 45min"));
		track.addTalk(new Talk("Lua for the Masses 30min"));
		track.addTalk(new Talk("Ruby Errors from Mismatched Gem Versions 45min"));
	}

}
