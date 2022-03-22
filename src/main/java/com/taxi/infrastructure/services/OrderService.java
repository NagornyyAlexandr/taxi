package com.taxi.infrastructure.services;

import com.taxi.domain.models.Order;

public interface OrderService extends BaseService<Order> {
    Order costCalculation(Order order);
}
