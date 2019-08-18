package my.project.OnlineShopWithSpringBoot.service.impl;

import my.project.OnlineShopWithSpringBoot.entity.Basket;
import my.project.OnlineShopWithSpringBoot.repository.BasketJpaRepository;
import my.project.OnlineShopWithSpringBoot.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketJpaRepository basketJpaRepository;

    @Transactional
    @Override
    public void add(Basket basket) {
        basketJpaRepository.save(basket);
    }

    @Transactional
    @Override
    public Optional<Basket> getBasketForUser(long userID) {
        return Optional.ofNullable(basketJpaRepository.getBasketByUserId(userID));
    }

    @Transactional
    @Override
    public void update(Basket basket) {
        basketJpaRepository.save(basket);
    }
}
