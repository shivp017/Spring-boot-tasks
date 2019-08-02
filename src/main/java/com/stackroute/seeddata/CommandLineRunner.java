package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunner(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;


    }




    @Override
    public void run(String... args) throws Exception {
        Track track3=new Track(4,"nothing more","Armaa");
        trackRepository.save(track3);
    }
}
