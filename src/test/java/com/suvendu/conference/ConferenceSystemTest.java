package com.suvendu.conference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.suvendu.conference.domain.Track;

public class ConferenceSystemTest {
	
	private ConferenceSystem  conferenceSystem = new  ConferenceSystem();
	
	private static final String TRACK_NAME = "Track1";
	
	@Test
	public void systemShouldAbletoGetTrackByName() {
		
		conferenceSystem.createTrack(TRACK_NAME);
		Track track = conferenceSystem.getTrack(TRACK_NAME);
		assertNotNull(track);
		
	}
	
	@Test
	public void systemShouldAbletoCreateTrack() {
		Track track = conferenceSystem.createTrack(TRACK_NAME);
		assertNotNull(track);
	}
	
	@Test
	public void systemShouldAbletoGetAllTracks() {
		conferenceSystem.createTrack(TRACK_NAME);
		conferenceSystem.createTrack("Track2");
		
		List<Track> tracks = conferenceSystem.getAllTracks();
		assertEquals(2, tracks.size());
	}

}
