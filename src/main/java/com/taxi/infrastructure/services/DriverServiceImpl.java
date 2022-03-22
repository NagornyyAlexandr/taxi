package com.taxi.infrastructure.services;

import com.taxi.domain.models.Driver;
import com.taxi.infrastructure.repositories.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements BaseService<Driver> {
    //Репозиторий
    private final DriverRepository repository;

    //Сохранить новую запись
    @Override
    public Driver create(Driver driver) {
        return repository.save(driver);
    }

    //Сохранить массив новых записей
    @Override
    public List<Driver> create(Iterable<Driver> drivers) {
        return repository.saveAll(drivers);
    }

    //Обновить имеющуюся запись
    @Override
    public Driver update(Driver driver, Driver driverFromDb) {
        driverFromDb.setName(driver.getName());
        driverFromDb.setPhone(driver.getName());
        driverFromDb.setCar(driver.getCar());

        return repository.save(driverFromDb);
    }

    //Удалить запись используя его объект
    @Override
    public void delete(Driver driver) {
        repository.delete(driver);
    }

    //Удалить массив записей
    @Override
    public void delete(Iterable<Driver> drivers) {
        repository.deleteAll(drivers);
    }

    //Удалить запись по Id
    @Override
    public void delete(Integer Id) {
        repository.deleteById(Id);
    }

    //Чтение всех записей с базы данных (+поиск по полям)
    @Override
    public List<Driver> read(Example<Driver> example) {
        return repository.findAll(example);
    }

    //Вывод записи по Id
    @Override
    public Driver read(Integer Id) throws Exception {
        Optional<Driver> optional = repository.findById(Id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Driver not found!");
        }
    }
}
