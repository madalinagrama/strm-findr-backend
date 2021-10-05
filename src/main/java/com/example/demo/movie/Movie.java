package com.example.demo.movie;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    private Long id;
    private String countries;
//    @ElementCollection
//    private List<String> genres = new ArrayList<String>();
    private int genres;
    private String imdbID;
    private String originalTitle;
    private String overview;
    private String posterURL;
    private String streamingInfo;

    public Movie(String countries, int genres, String imdbID, String originalTitle, String overview, String posterURL, String streamingInfo) {
        this.countries = countries;
        this.genres = genres;
        this.imdbID = imdbID;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterURL = posterURL;
        this.streamingInfo = streamingInfo;
    }

}
