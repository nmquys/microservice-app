package com.nmquys.productservice.service;

import com.nmquys.productservice.dto.ProductRequestDto;
import com.nmquys.productservice.dto.ProductResponseDto;
import com.nmquys.productservice.model.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductRequestDto productRequest);
    List<ProductResponseDto> getAllProducts();
}
