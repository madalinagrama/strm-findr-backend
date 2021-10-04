package com.example.demo.appuser;

import com.example.demo.auth.models.User;
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

    @GetMapping
    public List<User> getUsers () {
        return userService.getUsers();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void registerNewUser(@Validated @RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }
}
