package com.suvendu.conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suvendu.conference.domain.Track;

public class ConferenceSystem {
	
	private Map<String , Track> tracks;
	
	
	public ConferenceSystem() {
		tracks = new HashMap<>();
	}
	public Track createTrack(String trackName) {
		Track track = new Track();
		tracks.put(trackName, track);
		return track;
	}
	
	public Track getTrack(String trackName) {
		return tracks.get(trackName);
	}
	public List<Track> getAllTracks() {
		return new ArrayList<Track>(tracks.values());
	}

	

}
