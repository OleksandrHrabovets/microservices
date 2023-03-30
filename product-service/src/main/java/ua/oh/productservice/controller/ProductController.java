package ua.oh.productservice.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.oh.productservice.dto.ProductDto;
import ua.oh.productservice.model.Product;
import ua.oh.productservice.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {
    return ResponseEntity.ok(productService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable String id) {
    return ResponseEntity.ok(productService.getById(id).orElseThrow());
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody ProductDto productDto) {
    return ResponseEntity.ok(productService.create(productDto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable String id, @RequestBody ProductDto productDto) {
    return ResponseEntity.ok(productService.update(id, productDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteById(@PathVariable String id) {
    productService.deleteById(id);
    return ResponseEntity.ok().build();
  }

}
