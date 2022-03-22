package com.taxi.infrastructure;

import com.taxi.domain.models.User;
import com.taxi.infrastructure.repositories.UserRepository;
import com.taxi.infrastructure.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DbInit implements CommandLineRunner {
    private UserService service;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Delete all
        //this.userRepository.deleteAll();

        //User admin = new User();
        //admin.setUsername("admin");
        //admin.setPassword(passwordEncoder.encode("admin"));
        //admin.setPhone("222222");
        //admin.setName("Главный администратор");
        //admin.setRoles("ADMIN");
        //admin.setDate(LocalDateTime.now());
        //service.create(admin);

        //User user = new User();
        //user.setUsername("user");
        //user.setPassword(passwordEncoder.encode("1"));
        //user.setPhone("903456");
        //user.setName("Тестовый пользователь");
        //user.setRoles("USER");
        //user.setDate(LocalDateTime.now());
        //service.create(user);
    }
}
