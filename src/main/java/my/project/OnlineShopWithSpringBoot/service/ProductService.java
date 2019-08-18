package my.project.OnlineShopWithSpringBoot.service;

import my.project.OnlineShopWithSpringBoot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void add(Product product);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    boolean isInputDataCorrect(String title, String description, double price);

    void update(Product product);

    void delete(Product product);
}
