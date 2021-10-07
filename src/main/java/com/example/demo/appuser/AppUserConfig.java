package com.example.demo.appuser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner commandLineRunner(AppUserRepository appUserRepository) {
        return args -> {
            AppUser appUser1 = new AppUser(
                    "andreipandit",
                    "andrei.pandit@gmail.com",
                    "123"
                    );
            AppUser appUser2 = new AppUser(
                    "mariaionescu",
                    "mariat@gmail.com",
                    "1234");
            AppUser appUser3 = new AppUser(
                    "marinescu",
                    "i.marinescu@gmail.com",
                    "123"
            );

//            appUserRepository.saveAll(List.of(appUser1, appUser2, appUser3));

        };
    }
}
