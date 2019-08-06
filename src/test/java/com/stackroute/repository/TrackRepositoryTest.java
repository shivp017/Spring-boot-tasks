package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {



        @Autowired
        TrackRepository trackRepository;
        Track track;

        @Before
        public void setUp()
        {
            track = new Track();
            track.setId(101);
            track.setName("track2");

            track.setComments("comments2");

        }

        @After
        public void tearDown(){

            trackRepository.deleteAll();
        }


        @Test
        public void testSaveUser(){
            trackRepository.save(track);
            Track fetchUser = trackRepository.findById(track.getId()).get();
            Assert.assertEquals(101,fetchUser.getId());

        }

        @Test
        public void testSaveUserFailure(){
            Track testUser = new Track(7,"track5","Comments3");
            trackRepository.save(track);
            Track fetchUser = trackRepository.findById(track.getId()).get();
            Assert.assertNotSame(testUser,track);
        }

        @Test
        public void testGetAllUser(){
            Track u = new Track(8,"helloo1","comments1");
            Track u1 = new Track(9,"hello2","comments7");
            trackRepository.save(u);
            trackRepository.save(u1);

            List<Track> list = trackRepository.findAll();
            Assert.assertEquals("helloo1",list.get(0).getName());




        }}


