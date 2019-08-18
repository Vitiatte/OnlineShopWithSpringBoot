package my.project.OnlineShopWithSpringBoot.service;

import my.project.OnlineShopWithSpringBoot.entity.Order;

import java.util.Optional;

public interface OrderService {

    long add(Order order);

    Optional<Order> getOrderById(Long orderId);

    void update(Order order);

    boolean isDeliveryDataCorrect(String email, String address);

    boolean checkVerificationCode(Long orderId, String checkCode);
}
