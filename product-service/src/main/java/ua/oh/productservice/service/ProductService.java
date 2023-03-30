package ua.oh.productservice.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.oh.productservice.dto.ProductDto;
import ua.oh.productservice.model.Product;
import ua.oh.productservice.repository.ProductRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAll() {
    log.info("getAll");
    return productRepository.findAll();
  }

  public Optional<Product> getById(String id) {
    log.info("getById {}", id);
    return productRepository.findById(id);
  }

  public Product create(ProductDto productDto) {
    log.info("create {}", productDto);
    return productRepository.save(Product.builder()
        .name(productDto.name())
        .description(productDto.description())
        .price(productDto.price())
        .build());
  }

  public Product update(String id, ProductDto productDto) {
    log.info("update id{}: {}", id, productDto);
    Product product = productRepository.findById(id).orElseThrow();
    log.info("update product {}", product);
    product.setName(productDto.name());
    product.setDescription(productDto.description());
    product.setPrice(productDto.price());
    return productRepository.save(product);
  }

  public void deleteById(String id) {
    Product product = productRepository.findById(id).orElseThrow();
    log.info("deleteById id{}", id);
    productRepository.delete(product);
  }
}
