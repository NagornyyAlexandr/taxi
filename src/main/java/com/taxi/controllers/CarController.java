package com.taxi.controllers;

import com.taxi.domain.models.Car;
import com.taxi.infrastructure.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    //Сервис для работы с репозиторием
    private final BaseService<Car> service;

    //Добавить новую запись
    @PostMapping
    private Car create(@RequestBody Car car) {
        return service.create(car);
    }

    //Добавить массив новых записей
    @PostMapping("array")
    private List<Car> create(@RequestBody Iterable<Car> cars) {
        return service.create(cars);
    }

    //Обновить запись
    @PutMapping("{id}")
    private Car update(@PathVariable("id") Car carFromDb,  @RequestBody Car car) {
        return service.update(car, carFromDb);
    }

    //Удалить запись
    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    //Вывести все записи (с возможностью поиска)
    @GetMapping
    private List<Car> read(Car car) {
        return service.read(Example.of(car, ExampleMatcher.matchingAll().withIgnoreCase()));
    }

    //Вывести запись по ID
    @GetMapping("{id}")
    private Car read(@PathVariable Integer id) throws Exception {
        return service.read(id);
    }
}
