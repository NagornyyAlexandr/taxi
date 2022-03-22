package com.taxi.domain.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @Column(name = "driver_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Код водителя
    private Integer id;

    //Имя пользователя
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    //Номер телефона
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    //Машина
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Car car;
}
