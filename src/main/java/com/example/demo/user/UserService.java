package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(
                    1L,
                    "Andrei",
                    "Pandit",
                    "andrei.pandit@gmail.com",
                    "123",
                    UserRole.USER),
            new User(
                    2L,
                    "Maria",
                    "Ionescu",
                    "mariat@gmail.com",
                    "1234",
                    UserRole.USER),
            new User(
                    3L,
                    "Ion",
                    "Marinescu",
                    "i.marinescu@gmail.com",
                    "123",
                    UserRole.ADMIN
            )
    ));

    public List<User> getUsers () {
        return users;
    }

    public User getUser(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public void addNewUser(User user) {
        users.add(user);
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public void updateUser(User user, Long id) {
        int counter = 0;
        for (User user1 : users) {
            if (user1.getId().equals(id)) {
                users.set(counter, user);
            }
            counter++;
        }
    }
}
