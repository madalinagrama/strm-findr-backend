package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
public class AppUserController {

    private final AppUserService userService;

    @Autowired
    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<AppUser> getUsers () {
        return userService.getUsers();
    }

    @GetMapping(path = "/profile/{id}")
    public AppUser getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void registerNewUser(@Validated @RequestBody AppUser user) {
        userService.registerNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}/edit")
    public void updateUser(@PathVariable("id") Long id, @RequestBody AppUser user) {
        userService.updateUser(id, user);
    }
}
