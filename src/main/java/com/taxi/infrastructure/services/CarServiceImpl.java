package com.taxi.infrastructure.services;

import com.taxi.domain.models.Car;
import com.taxi.infrastructure.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements BaseService<Car> {
    //Репозиторий
    private final CarRepository repository;

    //Сохранить новую запись
    @Override
    public Car create(Car car) {
        return repository.save(car);
    }

    //Сохранить массив новых записей
    @Override
    public List<Car> create(Iterable<Car> cars) {
        return repository.saveAll(cars);
    }

    //Обновить имеющуюся запись
    @Override
    public Car update(Car car, Car carFromDb) {
        carFromDb.setName(car.getName());
        carFromDb.setNumberCar(car.getNumberCar());
        carFromDb.setColor(car.getColor());
        
        return repository.save(carFromDb);
    }

    //Удалить запись используя его объект
    @Override
    public void delete(Car car) {
        repository.delete(car);
    }

    //Удалить массив записей
    @Override
    public void delete(Iterable<Car> cars) {
        repository.deleteAll(cars);
    }

    //Удалить запись по Id
    @Override
    public void delete(Integer Id) {
        repository.deleteById(Id);
    }

    //Чтение всех записей с базы данных (+поиск по полям)
    @Override
    public List<Car> read(Example<Car> example) {
        return repository.findAll(example);
    }

    //Вывод записи по Id
    @Override
    public Car read(Integer Id) throws Exception {
        Optional<Car> optional = repository.findById(Id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Car not found!");
        }
    }
}
