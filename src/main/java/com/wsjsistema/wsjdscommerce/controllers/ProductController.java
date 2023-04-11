package com.wsjsistema.wsjdscommerce.controllers;

import com.wsjsistema.wsjdscommerce.entities.Product;
import com.wsjsistema.wsjdscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @GetMapping
    public String teste(){
        Optional<Product> result =  repository.findById(1L);
        Product product = result.get();
        return  product.getName();
    }


}
