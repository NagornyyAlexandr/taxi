package com.taxi.infrastructure.services;

import com.taxi.domain.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//Сервис для работы с Юзерами
public interface UserService extends BaseService<User> {
    //Поиск по логину
    User findByUsername(String login) throws Exception;
}
