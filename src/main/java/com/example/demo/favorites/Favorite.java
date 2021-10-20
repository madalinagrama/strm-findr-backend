package com.example.demo.favorites;

import com.example.demo.appuser.AppUser;
import com.example.demo.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Favorite {
        @Id
        @SequenceGenerator(name = "favorite_sequence", sequenceName = "favorite_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_sequence")
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private AppUser appUser;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Movie> movies;
}
