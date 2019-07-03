package com.suvendu.conference.domain;

import com.suvendu.conference.exception.ConferenceException;

public final class Talk {

	private static final int LIGHTING_MINS = 5;
	private final String strTalk;
	private final Integer duration;
	private String startTime;

	public Talk(String talk) {
		validateTalk(talk);
		String lastWord = getLastWord(talk);
		validateDuration(lastWord);
		this.duration = lastWord.equals("lightning") ? LIGHTING_MINS : Integer.parseInt(lastWord.replace("min", ""));
		this.strTalk = talk;

	}

	private String getLastWord(String talk) {
		String[] words = talk.split(" ");
		return words[words.length - 1];
		
	}

	private void validateDuration(String lastWord) {
		if(lastWord.equals("lightning")){
			return;
		}
		if (!lastWord.contains("min")) {
			throw new ConferenceException("Invalid talk duration should be in mins");
		}

	}

	private void validateTalk(String talk) {
		if (null == talk || "".equals(talk)) {
			throw new ConferenceException("Blank or null talk");
		}
	}

	public Integer getDuration() {
		return this.duration;
	}

	@Override
	public String toString() {
		return startTime + " " + strTalk;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
		
	}
	
	public String getStartTime() {
		return this.startTime;
	}
}
