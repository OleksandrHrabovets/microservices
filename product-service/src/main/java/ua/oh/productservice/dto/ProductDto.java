package ua.oh.productservice.dto;

import java.math.BigDecimal;

public record ProductDto(String name, String description,BigDecimal price) {
}
