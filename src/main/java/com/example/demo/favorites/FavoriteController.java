package com.example.demo.favorites;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth/favorites")
@CrossOrigin
@Slf4j
public class FavoriteController {
    private final FavoriteRepository favoriteRepository;
    private final AppUserRepository appUserRepository;

    @GetMapping(path = "/{userId}")
    public List<Favorite> getAllFavoritesByUserId(@PathVariable Long userId){
        AppUser appUser = appUserRepository.findUserById(userId);
        return favoriteRepository.findFavoritesByAppUser(appUser);
    }

    @PostMapping(path = "/add_favorites")
    public ResponseEntity<?> addFavorites(@RequestBody Favorite favorite) {
        Favorite favorite1 = new Favorite();
        log.info(String.valueOf(favorite));
        favorite1.setAppUser(appUserRepository.findById(favorite.getId()).get());
        if (!favoriteRepository.existsByAppUserId(appUserRepository.findById(favorite.getId()).get().getId())) {
            favoriteRepository.save(favorite1);
            return ResponseEntity.ok("Movie was added to favorites!");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "/remove/{movieId}/{userId}")
    @Transactional
    public ResponseEntity<?> deleteFavoriteById(@PathVariable(name = "movieId") Long movieId, @PathVariable(name = "userId") Long userId) {
        favoriteRepository.deleteByMovieIdAndAppUserId(movieId, userId);
        return ResponseEntity.ok("Movie with id " + movieId + "removed from favorites");
    }
}
