package com.stackroute.repository;

import com.mongodb.client.MongoDatabase;
import com.stackroute.domain.Track;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends MongoRepository<Track,Integer> {

//    @Query("SELECT t FROM Track t WHERE t.name like ?1")
    public Optional<List<Track>> findByName(String name);
}