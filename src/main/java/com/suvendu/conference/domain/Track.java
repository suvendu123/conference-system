package com.suvendu.conference.domain;

import com.suvendu.conference.exception.ConferenceException;

public class Track {

	private static final int NETWORK_END = 17;
	private static final int NETWORK_START = 16;
	private static final int AFTER_NOON_END = 16;
	private static final int AFTER_NOON_START = 13;
	private static final int LUNCH_TIME = 12;
	private static final int START_TIME = 9;
	private final Sessions morningSession;
	private final Sessions afterNoonSession;
	private final Sessions networkingSession;

	public Track() {
		morningSession = new Sessions(START_TIME, LUNCH_TIME);
		afterNoonSession = new Sessions(AFTER_NOON_START, AFTER_NOON_END);
		networkingSession = new Sessions(NETWORK_START, NETWORK_END);
	}

	public Sessions getMorningSession() {
		return morningSession;
	}

	public void addTalk(Talk talk) {
		boolean added = morningSession.addTalk(talk);
		if (!added) {
			added = afterNoonSession.addTalk(talk);
		}
		if (!added) {
			networkingSession.addTalk(new Talk("Network event 60min"));
			throw new ConferenceException("Track is full please create new track.");
		}

	}

	public Sessions getAfterNoonSession() {
		return afterNoonSession;
	}

	public Sessions getNetworkingSession() {
		return networkingSession;
	}

}
