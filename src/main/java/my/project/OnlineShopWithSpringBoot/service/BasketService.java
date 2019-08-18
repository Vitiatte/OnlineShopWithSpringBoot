package my.project.OnlineShopWithSpringBoot.service;

import my.project.OnlineShopWithSpringBoot.entity.Basket;

import java.util.Optional;

public interface BasketService {

    void add(Basket basket);

    Optional<Basket> getBasketForUser(long userID);

    void update(Basket basket);
}
