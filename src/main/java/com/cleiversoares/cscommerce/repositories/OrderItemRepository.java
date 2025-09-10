package com.cleiversoares.cscommerce.repositories;

import com.cleiversoares.cscommerce.entities.OrderItem;
import com.cleiversoares.cscommerce.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {


}
