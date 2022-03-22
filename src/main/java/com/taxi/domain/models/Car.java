package com.taxi.domain.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "car_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Код машины
    private Integer id;

    //Марка машины
    @Column(name = "name", nullable = false)
    private String name;

    //Номер машины
    @Column(name = "number_car", nullable = false, unique = true)
    private String numberCar;

    //Цвет машины
    @Column(name = "color", nullable = false)
    private String color;
}
