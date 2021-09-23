package com.example.demo.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/user")
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

    @GetMapping(path = "{id}")
    public Optional<AppUser> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void registerNewUser(@RequestBody AppUser user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id,
                           @RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String lastName,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password,
                           @RequestParam(required = false) AppUserRole appUserRole
                           ) {
        userService.updateUser(id, firstName, lastName, email, password, appUserRole);
    }
}
