package com.taxi.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Код заказа
    private Integer id;

    //Водитель
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private Driver driver;

    //Клиент
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    //Откуда забрать клиента
    @Column(name = "address_start", nullable = false)
    private String addressStart;

    //Куда отвезти клиента
    @Column(name = "address_end", nullable = false)
    private String addressEnd;

    @Column(name = "order_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //Время начала выполнения заказа
    private LocalDateTime orderTime;

    @Column(name = "order_time_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //Время завершение заказа
    private LocalDateTime orderTimeEnd;

    @Column(name = "price")
    //Цена за заказ.
    private long price;
}
