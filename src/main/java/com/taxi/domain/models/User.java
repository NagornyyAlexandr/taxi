package com.taxi.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    //Код пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    //Логин
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    //Пароль
    @Column(name = "password", nullable = false)
    private String password;

    //Имя пользователя
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    //Номер телефона
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    //Дата регистрации в БД
    @Column(name = "date_reg", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "roles")
    private String roles;

    public List<String> getRoleList(){
        if(this.roles != null && this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
