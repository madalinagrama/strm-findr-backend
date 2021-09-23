package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Optional<AppUser> getUser(Long id) {
        return appUserRepository.findById(id);
    }

    public void addNewUser(AppUser user) {
        Optional<AppUser> appUserOptional = appUserRepository.findAppUserByEmail(user.getEmail());

        if (appUserOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        appUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = appUserRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("User with id: " + id + " does not exist!");
        }
        appUserRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String firstName, String lastName, String email, String password, AppUserRole appUserRole) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with id " + id + " does not exist!"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<AppUser> appUserOptional = appUserRepository.findAppUserByEmail(email);
            if (appUserOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
        }
        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }
        if (appUserRole != null && !Objects.equals(user.getUserRole(), appUserRole)) {
            user.setUserRole(appUserRole);
        }
    }
}
