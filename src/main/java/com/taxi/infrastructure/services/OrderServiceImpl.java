package com.taxi.infrastructure.services;

import com.taxi.domain.models.Order;
import com.taxi.infrastructure.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    //Репозиторий
    private final OrderRepository repository;

    //Сохранить новую запись
    @Override
    public Order create(Order order) {
        order.setOrderTime(LocalDateTime.now());

        return repository.save(order);
    }

    //Сохранить массив новых записей
    @Override
    public List<Order> create(Iterable<Order> orders) {
        for(Order order: orders){
            order.setOrderTime(LocalDateTime.now());
        }

        return repository.saveAll(orders);
    }

    //Обновить имеющуюся запись
    @Override
    public Order update(Order order, Order orderFromDb) {
        orderFromDb.setDriver(order.getDriver());
        orderFromDb.setUser(order.getUser());
        orderFromDb.setOrderTime(order.getOrderTime());
        orderFromDb.setOrderTimeEnd(order.getOrderTimeEnd());
        orderFromDb.setAddressStart(order.getAddressStart());
        orderFromDb.setAddressEnd(order.getAddressEnd());
        orderFromDb.setPrice(order.getPrice());

        return repository.save(orderFromDb);
    }

    //Удалить запись используя его объект
    @Override
    public void delete(Order order) {
        repository.delete(order);
    }

    //Удалить массив записей
    @Override
    public void delete(Iterable<Order> orders) {
        repository.deleteAll(orders);
    }

    //Удалить запись по Id
    @Override
    public void delete(Integer Id) {
        repository.deleteById(Id);
    }

    //Чтение всех записей с базы данных (+поиск по полям)
    @Override
    public List<Order> read(Example<Order> example) {
        return repository.findAll(example);
    }

    //Вывод записи по Id
    @Override
    public Order read(Integer Id) throws Exception {
        Optional<Order> optional = repository.findById(Id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Order not found!");
        }
    }

    //Расчет стоимости
    @Override
    public Order costCalculation(Order order) {
        long between_minutes = order.getOrderTimeEnd().getMinute() - order.getOrderTime().getMinute();
        //Минимальная стоимость 75р. Одна минута стоит 7р
        long price = (long) (between_minutes * 7 + 75.0);
        order.setPrice(price);
        return order;
    }
}
