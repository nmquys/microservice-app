package com.nmquys.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequestDto(Long id,
                                String orderNumber,
                                String SkuCode,
                                BigDecimal price,
                                Integer quantity) {

}
