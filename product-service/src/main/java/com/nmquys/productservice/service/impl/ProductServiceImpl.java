package com.nmquys.productservice.service.impl;

import com.nmquys.productservice.dto.ProductRequestDto;
import com.nmquys.productservice.dto.ProductResponseDto;
import com.nmquys.productservice.model.Product;
import com.nmquys.productservice.repository.ProductRepository;
import com.nmquys.productservice.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public Product createProduct(ProductRequestDto productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
        return product;
    }

    public List<ProductResponseDto> getAllProducts()
    {
        return productRepository.findAll()
                .stream().map(this::transformToDTO).collect(Collectors.toList());
    }

    private ProductResponseDto transformToDTO(Product product)
    {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
