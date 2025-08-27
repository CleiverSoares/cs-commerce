package com.cleiversoares.cscommerce.controllers;

import com.cleiversoares.cscommerce.dto.ProductDTO;
import com.cleiversoares.cscommerce.entities.Product;
import com.cleiversoares.cscommerce.repositories.ProductRepository;
import com.cleiversoares.cscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
