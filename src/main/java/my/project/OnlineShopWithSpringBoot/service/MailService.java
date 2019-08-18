package my.project.OnlineShopWithSpringBoot.service;

import my.project.OnlineShopWithSpringBoot.entity.Order;

public interface MailService {

    void sendCheckCode(Order order);
}
