package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@ToString
@Document(collection = "track")
@Component
@NoArgsConstructor
public class Track {
//variable declared for track id ,track name and comments
    @Id
    int id;
    String name;
    String comments;

}
