package my.project.OnlineShopWithSpringBoot.repository;

import my.project.OnlineShopWithSpringBoot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}

