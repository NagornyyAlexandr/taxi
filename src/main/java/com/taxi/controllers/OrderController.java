package com.taxi.controllers;

import com.taxi.domain.models.Order;
import com.taxi.infrastructure.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    //Сервис для работы с репозиторием
    private final OrderService service;

    //Добавить новую запись
    @PostMapping
    private Order create(@RequestBody Order order) {
        return service.create(order);
    }

    //Добавить массив новых записей
    @PostMapping("array")
    private List<Order> create(@RequestBody Iterable<Order> orders) {
        return service.create(orders);
    }

    //Обновить запись
    @PutMapping("{id}")
    private Order update(@PathVariable("id")  Order orderFromDb, @RequestBody Order order) {
        return service.update(order, orderFromDb);
    }

    //Удалить запись
    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    //Вывести все записи (с возможностью поиска)
    @GetMapping
    private List<Order> read(Order order) {
        return service.read(Example.of(order, ExampleMatcher.matchingAll().withIgnoreCase()));
    }

    //Вывести запись по ID
    @GetMapping("{id}")
    private Order read(@PathVariable Integer id) throws Exception {
        return service.read(id);
    }

    @PutMapping("finish/{id}")
    private Order finishTrip(@PathVariable("id")  Order orderPay){
        return service.costCalculation(orderPay);
    }
}
