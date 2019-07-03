package com.suvendu.conference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.suvendu.conference.domain.Sessions;
import com.suvendu.conference.domain.Talk;

public class SessionTest {
	
	private Sessions session ;
	
	@Before
	public void setUp() {
		session = new Sessions(9, 12);
	}
	
	@Test
	public void shouldAddFirstTalkAt9AM() {
		session.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		assertEquals("09:00 AM Writing Fast Tests Against Enterprise Rails 60min",session.getTalkByTime("09:00 AM").toString());
	}
	
	@Test
	public void shouldAddNextTalkJustAfter() {
		session.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		session.addTalk(new Talk("Ruby Errors from Mismatched Gem Versions 45min"));
		
		Talk talk = session.getTalkByTime("10:00 AM");
		assertEquals("10:00 AM Ruby Errors from Mismatched Gem Versions 45min", talk.toString());
		
	}
	
	@Test
	public void shouldReturnFalseIfLunchTimeCrossed() {
		assertTrue(session.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min")));
		assertTrue(session.addTalk(new Talk("Ruby Errors from Mismatched Gem Versions 45min")));
		assertTrue(session.addTalk(new Talk("Communicating Over Distance 60min")));
		assertFalse(session.addTalk(new Talk("Sit Down and Write 30min")));
		assertEquals(3, session.getAllTalks().size());
	}

	@Test
	public void shouldAddFirstTalkAt1PM() {
		session = new Sessions(13, 16);
		session.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		assertEquals("01:00 PM Writing Fast Tests Against Enterprise Rails 60min",session.getTalkByTime("01:00 PM").toString());
	}
	
	@Test
	public void shouldAddNextTalkInEveningJustAfter() {
		session = new Sessions(13, 16);
		session.addTalk(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		session.addTalk(new Talk("Ruby Errors from Mismatched Gem Versions 45min"));
		
		Talk talk = session.getTalkByTime("02:00 PM");
		assertEquals("02:00 PM Ruby Errors from Mismatched Gem Versions 45min", talk.toString());
		
	}
	
	
}
