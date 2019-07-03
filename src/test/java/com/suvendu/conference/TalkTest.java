package com.suvendu.conference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.suvendu.conference.domain.Talk;
import com.suvendu.conference.exception.ConferenceException;

public class TalkTest {
	
	@Test
	public void shouldCreateValidTalk() {
		Talk talk = new Talk("Communicating Over Distance 60min");
		assertEquals(new Integer(60), talk.getDuration());
	}
	
	@Test
	public void shouldCreateValidTalkWithLightning() {
		Talk talk = new Talk("Rails for Python Developers lightning");
		assertEquals(new Integer(5), talk.getDuration());
	}
	
	@Test(expected=ConferenceException.class)
	public void shouldThrowExceptionOnBlankTalk() {
		new Talk("");
	}
	
	@Test(expected=ConferenceException.class)
	public void shouldThrowExceptionOnInvalidTalk() {
		new Talk("Rails for Python Developers");
	}

}
