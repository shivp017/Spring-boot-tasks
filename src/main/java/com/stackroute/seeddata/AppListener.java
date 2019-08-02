package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
  private Track track;
  private Track track2;
  private TrackRepository trackRepository;


@Autowired
    public AppListener(Track track, TrackRepository trackRepository,Track track2) {
        this.track = track;
        this.trackRepository = trackRepository;
        this.track2 =track2;

    }

    public AppListener() {}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cre) {
     track.setName("Abc");
     track.setId(1);
     track.setComments("Arijit singh");
     trackRepository.save(track);
     track2.setName("xyz");
     track2.setId(2);
     track2.setComments("hmmmmmmmmm");
     trackRepository.save(track2);
     Track track3=new Track(3,"pqr","Armaan mallick");
     trackRepository.save(track3);

    }
}

