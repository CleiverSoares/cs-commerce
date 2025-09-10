package com.cleiversoares.cscommerce.services;

import com.cleiversoares.cscommerce.dto.CategoryDTO;
import com.cleiversoares.cscommerce.dto.OrderDTO;
import com.cleiversoares.cscommerce.dto.ProductDTO;
import com.cleiversoares.cscommerce.dto.ProdutoMinDTO;
import com.cleiversoares.cscommerce.entities.Category;
import com.cleiversoares.cscommerce.entities.Order;
import com.cleiversoares.cscommerce.entities.Product;
import com.cleiversoares.cscommerce.repositories.OrderRepository;
import com.cleiversoares.cscommerce.repositories.ProductRepository;
import com.cleiversoares.cscommerce.services.exceptions.DatabaseException;
import com.cleiversoares.cscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado! ID: " + id));
        return new OrderDTO(order);


    }


}
