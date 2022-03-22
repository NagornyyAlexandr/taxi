package com.taxi.controllers;

import com.taxi.domain.models.User;
import com.taxi.infrastructure.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    //Сервис для работы с репозиторием
    private final UserService service;

    //Добавить новую запись
    @PostMapping
    private User create(@RequestBody User user) {
        return service.create(user);
    }

    //Добавить массив новых записей
    @PostMapping("array")
    private List<User> create(@RequestBody Iterable<User> users) {
        return service.create(users);
    }

    //Обновить запись
    @PutMapping("{id}")
    private User update(@PathVariable("id") User userFromDb, @RequestBody User user) {
        return service.update(user, userFromDb);
    }

    //Удалить запись
    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    //Вывести все записи (с возможностью поиска)
    @GetMapping
    private List<User> read(User user) {
        return service.read(Example.of(user, ExampleMatcher.matchingAll().withIgnoreCase()));
    }

    //Вывести запись по ID
    @GetMapping("{id}")
    private User read(@PathVariable Integer id) throws Exception {
        return service.read(id);
    }

    //Поиск пользователя в базе данных
    @GetMapping("username/{login}")
    private User findByUsername(@PathVariable String login) throws Exception {
        return service.findByUsername(login);
    }
}
