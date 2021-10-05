package com.example.demo.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner2(MovieRepository movieRepository) {

        return args -> {
            Movie movie1 = new Movie(
                    "FR",
                    99,
                    "tt2125012",
                    "Agnès de ci de là Varda",
                    "A cultural travelogue miniseries from Agnès Varda.",
                    "https://image.tmdb.org/t/p/original/4FUWBC5LZbovsLvf6UsOaVkXgTN.jpg",
                    "mubi");
            Movie movie2 = new Movie(
                    "US",
                    16,
                    "tt0815744",
                    "DumbLand",
                    "A series of eight crudely animated shorts written, directed, and voiced by director David Lynch in 2002. The series details the daily routines of a dull-witted white trash man. ",
                    "https://image.tmdb.org/t/p/original/4Ue7tiq1DxOiO2fMhhYBVEYFxzH.jpg",
                    "mubi");
            Movie movie3 = new Movie("US",
                    35,
                    "tt10311562",
                    "#blackAF",
                    "A father takes an irreverent and honest approach to parenting and relationships.",
                    "https://image.tmdb.org/t/p/original/xccT6BWUYLf41UNHUWdvtqdH8rN.jpg",
                    "netflix");
            Movie movie4 = new Movie("US",
                    99,
                    "tt12759384",
                    "(Un)Well",
                    "This docuseries takes a deep dive into the lucrative wellness industry, which touts health and healing. But do the products live up to the promises?",
                    "https://image.tmdb.org/t/p/original/bC1CSudFJCvDm679fRtqdVHlDc3.jpg",
                    "netflix");
            Movie movie5 = new Movie("US",
                    35,
                    "tt11243606",
                    "100 días para enamorarnos",
                    "Two couples who struggle to be near each other decide to give another chance for each other, 100 days for them to fall back in love.",
                    "https://image.tmdb.org/t/p/original/r13t1ohRQAlZpsjxgTKY7ypkWPc.jpg",
                    "netflix");
            Movie movie6 = new Movie("JP",
                    9648,
                    "tt6686450",
                    "100万円の女たち",
                    "Five beautiful but mysterious women move in with unsuccessful novelist Shin, who manages their odd household in exchange for a tidy monthly sum.",
                    "https://image.tmdb.org/t/p/original/1p06R61PjdwiawDyh4KH33MnugH.jpg",
                    "netflix");
            Movie movie7 = new Movie("BE",
                    53,
                    "tt5203748",
                    "13 Geboden",
                    "A serial killer reverts to the 10 commandments in order to kick society a conscience with his crimes.",
                    "https://image.tmdb.org/t/p/original/kOxrZG0laX9KVWaIItyWkCC5YzK.jpg",
                    "netflix");
            Movie movie8 = new Movie("US",
                    18,
                    "tt1837492",
                    "13 Reasons Why",
                    "After a teenage girl's perplexing suicide, a classmate receives a series of tapes that unravel the mystery of her tragic choice.",
                    "https://image.tmdb.org/t/p/original/nel144y4dIOdFFid6twN5mAX9Yd.jpg",
                    "netflix");
            Movie movie9 = new Movie("US",
                    10767,
                    "tt8615966",
                    "13 Reasons Why: Beyond the Reasons",
                    "Cast members, writers, producers and mental health professionals discuss some of the difficult issues and themes explored in \"13 Reasons Why.\"",
                    "https://image.tmdb.org/t/p/original/aauFzhjAGSemDpDBSmWDJpkeQiw.jpg",
                    "netflix");
            Movie movie10 = new Movie("FR",
                    99,
                    "tt8194716",
                    "13 novembre : Fluctuat nec mergitur",
                    "Survivors and first responders share personal stories of anguish, kindness and bravery that unfolded amid the Paris terror attacks of Nov. 13, 2015.",
                    "https://image.tmdb.org/t/p/original/4DNfUpOm466GaC46l7AdFyPiKbB.jpg",
                    "netflix" );
            Movie movie11 = new Movie("ES",
                    12,
                    "tt11658082",
                    "3 Caminos",
                    "",
                    "https://image.tmdb.org/t/p/original/jlWwtwkN1YOiLmtgaKCS98l3WCA.jpg",
                    "prime" );
            Movie movie12 = new Movie("DE",
                    80,
                    "tt5754602",
                    "4 Blocks",
                    "Based in Neukölln, Berlin Toni manages the daily business of dealing with the Arabic gangs and ends up wanting to leave his old life behind for his family, but it's never that simple.",
                    "https://image.tmdb.org/t/p/original/jVObyxtNxuPbG5czuKvm7pW56EV.jpg",
                    "prime" );
            Movie movie13 = new Movie("US",
                    80,
                    "tt6794990",
                    "Absentia",
                    "A missing FBI agent reappears six years after being declared dead.",
                    "https://image.tmdb.org/t/p/original/uy236cUbjkG0ncSmNeMz2f2OO9Q.jpg",
                    "prime" );
            Movie movie14 = new Movie("US",
                    99,
                    "tt5637798",
                    "All or Nothing",
                    "For the first time in history, Amazon and NFL Films present an unprecedented inside look at the lives of players, coaches and owners of a franchise over the course ",
                    "https://image.tmdb.org/t/p/original/a3VFOFuhHXcXVmvHIUVDA4K8KFo.jpg",
                    "prime" );
            Movie movie15 = new Movie("GB",
                    99,
                    "tt7653274",
                    "All or Nothing: Manchester City",
                    "Legendary coach Pep Guardiola leads his Manchester City team through the 2017-18 football season.",
                    "https://image.tmdb.org/t/p/original/2Q3mKXNX7rm2kyPesS9KEFs8VcN.jpg",
                    "prime" );
            Movie movie16 = new Movie("US",
                    10764,
                    "tt8169088",
                    "All or Nothing: New Zealand All Blacks",
                    "Behind-the-scenes series following the New Zealand All Blacks rugby team throughout 2017, taking an in-depth look at the players and coaches on and off the field.",
                    "https://image.tmdb.org/t/p/original/uy3JYSAI81TQjXAhTzZ3nreXzP.jpg",
                    "prime" );
            Movie movie17 = new Movie("ES",
                    5,
                    "tt11621622",
                    "All or Nothing: Philadelphia Eagles",
                    "",
                    "https://image.tmdb.org/t/p/original/7LTN7nXSIVdbgqzb9tLAQzyuRm6.jpg",
                    "prime" );
            Movie movie18 = new Movie("US",
                    5,
                    "tt8134160",
                    "All or Nothing: The Michigan Wolverines",
                    "All or Nothing: The Michigan Wolverines goes behind-the-scenes of the winningest program in college football to chronicle Michigan's 2017 season. Head coach Jim Harbaugh ",
                    "https://image.tmdb.org/t/p/original/pa5OYdHAYNiX3pUTLHAHoaNLFXm.jpg",
                    "prime" );

            movieRepository.saveAll(List.of(movie1,movie2,movie3,movie4,movie5,movie6,movie7,movie8,movie9,movie10,movie11,movie12,movie13,movie14,movie15,movie16,movie17,movie18));
        };
    }
}
