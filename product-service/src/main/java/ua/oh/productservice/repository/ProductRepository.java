package ua.oh.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.oh.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
