package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    private List<AppUser> users = new ArrayList<>(Arrays.asList(

    ));

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser findById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find user with username: " + id));
    }

    public Optional<AppUser> getUser(Long id) {
        return appUserRepository.findById(id);
    }

    public void registerNewUser(AppUser user) {
        Optional<AppUser> appUserOptionalByEmail = appUserRepository.findAppUserByEmail(user.getEmail());

        if (appUserOptionalByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        appUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = appUserRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id: " + id + " does not exist!");
        }
        appUserRepository.deleteById(id);
    }

    public void updateUser(Long id, AppUser appUser) {
        boolean exists = appUserRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist!");
        }
        AppUser user = appUserRepository.getById(id);
        user.setFirstName(appUser.getFirstName());
        user.setLastName(appUser.getLastName());
        user.setUsername(appUser.getUsername());
        user.setEmail(appUser.getEmail());
        user.setPassword(appUser.getPassword());
        appUserRepository.save(user);
    }
}
