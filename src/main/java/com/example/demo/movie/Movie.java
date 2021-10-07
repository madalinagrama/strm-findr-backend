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
    private String imdbID;
    private String originalTitle;
    private int genres;
    private String countries;
    private String overview;
    private String posterURL;
    private String streamingInfo;

    public Movie(String imdbID, String originalTitle, int genres, String countries, String overview, String posterURL, String streamingInfo) {
        this.imdbID = imdbID;
        this.originalTitle = originalTitle;
        this.genres = genres;
        this.countries = countries;
        this.overview = overview;
        this.posterURL = posterURL;
        this.streamingInfo = streamingInfo;
    }
}
