package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(
                    UUID.randomUUID(),
                    "Andrei",
                    "Pandit",
                    "andrei.pandit@gmail.com",
                    "123",
                    UserRole.USER),
            new User(
                    UUID.randomUUID(),
                    "Maria",
                    "Ionescu",
                    "mariat@gmail.com",
                    "1234",
                    UserRole.USER),
            new User(
                    UUID.randomUUID(),
                    "Ion",
                    "Marinescu",
                    "i.marinescu@gmail.com",
                    "123",
                    UserRole.ADMIN
            )
    ));

    public List<User> getUsers() {
        return users;
    }

    public User getUser(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public void addNewUser(User user) {
//        User newUser = new User(user.getId(), u   ser.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserRole());
        users.add(user);
    }

    public void deleteUser(UUID id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public void updateUser(User user, UUID id) {
        users.remove(getUser(id));
        User newUser = new User(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getUserRole());
        users.add(newUser);
    }
}
