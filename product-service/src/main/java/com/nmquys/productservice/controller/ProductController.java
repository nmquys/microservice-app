package com.nmquys.productservice.controller;


import com.nmquys.productservice.dto.ProductRequestDto;
import com.nmquys.productservice.dto.ProductResponseDto;
import com.nmquys.productservice.model.Product;
import com.nmquys.productservice.service.IProductService;
import com.nmquys.productservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService iProductService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequestDto productRequest){
        return iProductService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> productList = iProductService.getAllProducts();
        return ResponseEntity.ok().body(productList);
    }
}
