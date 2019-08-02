package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
    @RequestMapping("/api/v1")
    public class TrackController {
        private TrackService trackService;


        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }
    //use postMapping to set tracks
        @PostMapping("track")
        public ResponseEntity<?> setTrack(@RequestBody Track track) throws TrackAlreadyExistsException{
            Track savedTrack=trackService.saveTrack(track);
              return new ResponseEntity<>(savedTrack, HttpStatus.OK);
//            try {
//                Track savedTrack=trackService.saveTrack(track);
//                return new ResponseEntity<>(savedTrack, HttpStatus.OK);
//            }
//            catch (TrackAlreadyExistsException ex){
//                return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//            }
        }
    //use getMapping to gettracksById
        @GetMapping("track/{id}")
        public ResponseEntity<?> getTrack(@PathVariable("id") int id) throws TrackNotFoundException{
            Track track=trackService.getTrackById(id);
            return new ResponseEntity<>(track,HttpStatus.OK);
//            try {
//                Track track=trackService.getTrackById(id);
//                responseEntity=new ResponseEntity<>(track,HttpStatus.OK);
//            }
//           catch (Exception ex){
//                responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//           }
//            return responseEntity;
        }
//use getMapping to get all tracks
        @GetMapping("tracks")
        public ResponseEntity<?> getAllTrack() throws Exception {
            ResponseEntity responseEntity;

            try {
                responseEntity = new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
            } catch (Exception ex) {
                responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }return responseEntity;
        }

        //Use DeleteMapping to delete a particular track given by id
        @DeleteMapping("track/{id}")
        public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {
            return new ResponseEntity<>(trackService.deleteTrackById(id), HttpStatus.OK);
//            try{
//                responseEntity = new ResponseEntity<>(trackService.deleteTrackById(id), HttpStatus.OK);}
//            catch (Exception ex){
//                responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//            }
//
//            return responseEntity;
        }


    //Use PatchMapping to update the element in database
    @PatchMapping("/track/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable("id") int id) throws TrackNotFoundException{
        return new ResponseEntity<>(trackService.updateTrackById(id, track), HttpStatus.OK);
//        try{
//            responseEntity = new ResponseEntity<>(trackService.updateTrackById(id, track), HttpStatus.OK);}
//        catch (Exception ex){
//            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//        }
//
//        return responseEntity;
    }
///get track by name
    @GetMapping("tracks/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) throws TrackNotFoundException{
        List<Track> track=trackService.findByName(name);
      return new ResponseEntity<>(track,HttpStatus.OK);

//            try {
//                List<Track> track=trackService.findByName(name);
//                responseEntity=new ResponseEntity<>(track,HttpStatus.OK);
//            }
//            catch (Exception ex){
//                responseEntity=new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//            }
//            return responseEntity;
      }}






