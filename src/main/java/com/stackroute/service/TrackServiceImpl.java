package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//service class
@Service
public class TrackServiceImpl implements TrackService {
    //declared trackRepository object of TrackRepository class
    private TrackRepository trackRepository;

    //autowired constructor
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    //implement of getTrackById() method
    @Override
    public Track getTrackById(int id) {
        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> trackList=trackRepository.findAll();
        return trackList;
    }


    @Override
    public List<Track> findByName(String name) {
        List<Track> foundTracks=trackRepository.findByName(name);
    return foundTracks;
    }

    //implement of deleteTrackById() method
    @Override
    public Track deleteTrackById(int id) {

        Optional<Track> optionalTrack = trackRepository.findById(id);
        trackRepository.deleteById(id);
        return optionalTrack.get();

    }

    //implement of updateTrackById() method
    @Override
    public Track updateTrackById(int id, Track track) {
        trackRepository.deleteById(id);
        return trackRepository.save(track);
    }


}




