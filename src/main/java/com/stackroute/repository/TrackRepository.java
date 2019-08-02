package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query("SELECT t FROM Track t WHERE t.name like ?1")
    public Optional<List<Track>> findByName(String name);
}