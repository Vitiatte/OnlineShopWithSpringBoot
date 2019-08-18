package my.project.OnlineShopWithSpringBoot.service.impl;

import my.project.OnlineShopWithSpringBoot.entity.Order;
import my.project.OnlineShopWithSpringBoot.exception.InvalidOrderIdException;
import my.project.OnlineShopWithSpringBoot.repository.OrderJpaRepository;
import my.project.OnlineShopWithSpringBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Transactional
    @Override
    public long add(Order order) {
        Optional<Long> optional = Optional.ofNullable(orderJpaRepository.save(order).getId());
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new InvalidOrderIdException("Order id didn't return from DB");
        }
    }

    @Transactional
    @Override
    public Optional<Order> getOrderById(Long id) {
        return Optional.ofNullable(orderJpaRepository.getOne(id));
    }

    @Transactional
    @Override
    public void update(Order order) {
        orderJpaRepository.save(order);
    }

    @Override
    public boolean isDeliveryDataCorrect(String email, String address) {
        return !email.isEmpty() && !address.isEmpty();
    }

    @Override
    public boolean checkVerificationCode(Long orderId, String checkCode) {
        Order order = orderJpaRepository.getOne(orderId);
        return order.getCheckCode().equals(checkCode);
    }
}
