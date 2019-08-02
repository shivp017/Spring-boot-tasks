package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Track {
//variable declared for track id ,track name and comments
    @Id
    int id;
    String name;
    String comments;


    public Track(int id, String name, String comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }

    public Track() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


//to-string method
    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
