package my.project.OnlineShopWithSpringBoot.repository;

import my.project.OnlineShopWithSpringBoot.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketJpaRepository extends JpaRepository<Basket, Long> {

    Basket getBasketByUserId(Long userId);
}

