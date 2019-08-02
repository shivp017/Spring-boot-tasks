package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("track already exist");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    //implement of getTrackById() method
    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {

            if (!trackRepository.existsById(id)){
                throw new TrackNotFoundException("Track not found");
            }
        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public List<Track> getAllTracks() {


        List<Track> trackList=trackRepository.findAll();
        return trackList;
    }


    @Override
    public List<Track> findByName(String name) throws TrackNotFoundException{
     if(trackRepository.findByName(name).isEmpty()){
         throw new TrackNotFoundException(("Track name not found"));
     }
        Optional<List<Track>> foundTracks=trackRepository.findByName(name);
//     foundTracks.isPresent();
    return foundTracks.get();
    }

    //implement of deleteTrackById() method
    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track id is not found");
        }
        Optional<Track> optionalTrack = trackRepository.findById(id);
        trackRepository.deleteById(id);
        return  optionalTrack;


    }

    //implement of updateTrackById() method
    @Override
    public Track updateTrackById(int id, Track track) throws TrackNotFoundException {
        if(!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track id you want to update is not found");
        }
        trackRepository.deleteById(id);
        return trackRepository.save(track);
    }


}




