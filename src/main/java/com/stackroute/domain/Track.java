package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Track {
//variable declared for track id ,track name and comments
    @Id
    int id;
    String name;
    String comments;


}
