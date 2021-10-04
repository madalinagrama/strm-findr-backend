package com.example.demo.appuser;

import com.example.demo.auth.models.User;
import com.example.demo.auth.models.ERole;
import com.example.demo.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository appUserRepository) {
        return args -> {
            User appUser1 = new User(
                    "Andrei",
                    "Pandit",
                    "andreipandit",
                    "andrei.pandit@gmail.com",
                    "123"
                    );
            User appUser2 = new User(
                    "Maria",
                    "Ionescu",
                    "mariaionescu",
                    "mariat@gmail.com",
                    "1234");
            User appUser3 = new User(
                    "Ion",
                    "Marinescu",
                    "marinescu",
                    "i.marinescu@gmail.com",
                    "123"
            );

            appUserRepository.saveAll(List.of(appUser1, appUser2, appUser3));

        };
    }
}
