package com.example.demo.favorites;

import com.example.demo.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findFavoritesByAppUser (AppUser appUser);

    boolean existsByAppUser(Long id);
}
