package com.wsjsistema.wsjdscommerce.controllers;

import com.wsjsistema.wsjdscommerce.dto.ProductDTO;
import com.wsjsistema.wsjdscommerce.entities.Product;
import com.wsjsistema.wsjdscommerce.repositories.ProductRepository;
import com.wsjsistema.wsjdscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping(value = "{id}")
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findByIDto(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);


    }


}
