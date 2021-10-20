package com.example.demo.favorites;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth/")
@CrossOrigin
@Slf4j
public class FavoriteController {
    private final FavoriteRepository favoriteRepository;
    private final AppUserRepository appUserRepository;

    @GetMapping(path = "/favorites/{id}")
    public List<Favorite> getAllFavoritesByUserId(@PathVariable Long id){
        AppUser appUser = appUserRepository.findUserById(id);
        return favoriteRepository.findFavoritesByAppUser(appUser);
    }
}
