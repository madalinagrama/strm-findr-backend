package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/auth")
public class AppUserController {

    private final AppUserService userService;

    @Autowired
    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping
    public List<AppUser> getUsers () {
        return userService.getUsers();
    }

    @CrossOrigin
    @GetMapping(path = "{id}")
    public Optional<AppUser> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @CrossOrigin
    @PostMapping
    public void registerNewUser(@Validated @RequestBody AppUser user) {
        userService.addNewUser(user);
    }

    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public void deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @CrossOrigin
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody AppUser user) {
        userService.updateUser(id, user);
    }
}
