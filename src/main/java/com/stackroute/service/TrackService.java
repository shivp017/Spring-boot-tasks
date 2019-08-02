package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

        public Track saveTrack(Track track) throws TrackAlreadyExistsException;
        public Track getTrackById(int id) throws TrackNotFoundException;
        public List<Track> getAllTracks();
        public List<Track> findByName(String name);
        public Track deleteTrackById(int id);
        public Track updateTrackById(int id,Track track);



}
