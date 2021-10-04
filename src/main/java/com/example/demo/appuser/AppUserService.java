package com.example.demo.appuser;

import com.example.demo.auth.models.User;
import com.example.demo.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppUserService {

    private final UserRepository appUserRepository;

    @Autowired
    public AppUserService(UserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    private List<User> users = new ArrayList<>(Arrays.asList(

    ));

    public List<User> getUsers() {

        return appUserRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return appUserRepository.findById(id);
    }

    public void addNewUser(User user) {
        Optional<User> appUserOptional = appUserRepository.findAppUserByEmail(user.getEmail());

        if (appUserOptional.isPresent()) {
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

    public void updateUser(Long id, User appUser) {
        boolean exists = appUserRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist!");
        }
        User user = appUserRepository.getById(id);
        user.setFirstName(appUser.getFirstName());
        user.setLastName(appUser.getLastName());
        user.setEmail(appUser.getEmail());
        user.setPassword(appUser.getPassword());
        appUserRepository.save(user);

    }
}
