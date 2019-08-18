package my.project.OnlineShopWithSpringBoot.service.impl;

import my.project.OnlineShopWithSpringBoot.entity.Product;
import my.project.OnlineShopWithSpringBoot.repository.ProductJpaRepository;
import my.project.OnlineShopWithSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Transactional
    @Override
    public void add(Product product) {
        productJpaRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> getProductById(Long id) {
        if (id > 0) {
            return Optional.ofNullable(productJpaRepository.getOne(id));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        return productJpaRepository.findAll();
    }

    @Override
    public boolean isInputDataCorrect(String title, String description, double price) {
        return Objects.nonNull(title)
                && Objects.nonNull(description)
                && !title.isEmpty()
                && !description.isEmpty()
                && price > 0.0;
    }

    @Transactional
    @Override
    public void update(Product product) {
        productJpaRepository.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productJpaRepository.delete(product);
    }
}
