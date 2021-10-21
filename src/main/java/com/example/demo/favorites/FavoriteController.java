package com.example.demo.favorites;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import com.example.demo.movie.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth/favorites")
@Slf4j
public class FavoriteController {

    private final FavoriteRepository favoriteRepository;
    private final AppUserRepository appUserRepository;
    private final MovieRepository movieRepository;
    private final FavoriteService favoriteService;

    @GetMapping(path = "/{userId}")
    public List<Favorite> getAllFavoritesByUserId(@PathVariable Long userId){
        AppUser appUser = appUserRepository.findById(userId).get();
        log.info(String.valueOf(appUser.getEmail()));
        List<Favorite> favorites = favoriteRepository.getAllByUser(appUser);
        log.info(String.valueOf(favorites));
        return favorites;
    }

    @PostMapping(path = "/add-favorite")
    public ResponseEntity<?> addFavorites(@RequestBody FavoriteDto favoriteDto) {
        Favorite favorite = new Favorite();
        log.info(String.valueOf(favoriteDto));
        favorite.setUser(appUserRepository.findById(favoriteDto.getUserId()).get());
        log.info(String.valueOf(favoriteDto.getMovieId()));
        favorite.setMovie(movieRepository.findById(favoriteDto.getMovieId()).get());

        favoriteService.addFavorites(favorite);

        return ResponseEntity.ok("Movie added to database");
    }

    @Transactional
    @DeleteMapping(path = "/remove/{movieId}/{userId}")
    public ResponseEntity<?> deleteFavoriteById(@PathVariable(name = "movieId") Long movieId, @PathVariable(name = "userId") Long userId) {
        favoriteRepository.deleteByMovieIdAndAppUserId(movieId, userId);
        return ResponseEntity.ok("Movie with id " + movieId + " removed from favorites");
    }
}
