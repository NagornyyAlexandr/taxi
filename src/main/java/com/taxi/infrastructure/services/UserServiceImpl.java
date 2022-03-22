package com.taxi.infrastructure.services;

import com.taxi.domain.models.User;
import com.taxi.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //Репозиторий
    private final UserRepository repository;

    //Сохранить новую запись
    @Override
    public User create(User user) {
        user.setDate(LocalDateTime.now());

        return repository.save(user);
    }

    //Сохранить массив новых записей
    @Override
    public List<User> create(Iterable<User> users) {
        for (User user: users) {
            user.setDate(LocalDateTime.now());
        }

        return repository.saveAll(users);
    }

    //Обновить имеющуюся запись
    @Override
    public User update(User user, User userFromDb) {
        userFromDb.setRoles(user.getRoles());
        userFromDb.setUsername(user.getUsername());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setName(user.getName());
        userFromDb.setPhone(user.getPhone());
        userFromDb.setDate(user.getDate());

        return repository.save(userFromDb);
    }

    //Удалить запись используя его объект
    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    //Удалить массив записей
    @Override
    public void delete(Iterable<User> users) {
        repository.deleteAll(users);
    }

    //Удалить запись по Id
    @Override
    public void delete(Integer Id) {
        repository.deleteById(Id);
    }

    //Чтение всех записей с базы данных (+поиск по полям)
    @Override
    public List<User> read(Example<User> example) {
        return repository.findAll(example);
    }

    //Вывод записи по Id
    @Override
    public User read(Integer Id) throws Exception {
        Optional<User> optional = repository.findById(Id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("User not found!");
        }
    }

    //Поиск пользователя по логину
    @Override
    public User findByUsername(String login) throws Exception {
        return repository.findByUsername(login);
    }
}
