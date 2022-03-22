package com.taxi.controllers;

import com.taxi.domain.models.Driver;
import com.taxi.infrastructure.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    //Сервис для работы с репозиторием
    private final BaseService<Driver> service;

    //Добавить новую запись
    @PostMapping
    private Driver create(@RequestBody Driver driver) {
        return service.create(driver);
    }

    //Добавить массив новых записей
    @PostMapping("array")
    private List<Driver> create(@RequestBody Iterable<Driver> drivers) {
        return service.create(drivers);
    }

    //Обновить запись
    @PutMapping("{id}")
    private Driver update(@PathVariable("id") Driver driverFromDb,  @RequestBody Driver driver) {
        return service.update(driver, driverFromDb);
    }

    //Удалить запись
    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    //Вывести все записи (с возможностью поиска)
    @GetMapping
    private List<Driver> read(Driver driver) {
        return service.read(Example.of(driver, ExampleMatcher.matchingAll().withIgnoreCase()));
    }

    //Вывести запись по ID
    @GetMapping("{id}")
    private Driver read(@PathVariable Integer id) throws Exception {
        return service.read(id);
    }
}
