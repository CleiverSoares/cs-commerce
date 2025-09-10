package com.cleiversoares.cscommerce.dto;

import com.cleiversoares.cscommerce.entities.Order;
import com.cleiversoares.cscommerce.entities.OrderItem;
import com.cleiversoares.cscommerce.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(PaymentDTO payment, ClientDTO client, OrderStatus status, Instant moment, Long id) {
        this.payment = payment;
        this.client = client;
        this.status = status;
        this.moment = moment;
        this.id = id;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        if (entity.getPayment() != null) {
            payment = new PaymentDTO(entity.getPayment());
        }
        for( OrderItem item : entity.getItems()) {
            items.add(new OrderItemDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
