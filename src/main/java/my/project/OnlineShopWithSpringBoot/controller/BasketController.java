package my.project.OnlineShopWithSpringBoot.controller;

import my.project.OnlineShopWithSpringBoot.entity.Basket;
import my.project.OnlineShopWithSpringBoot.entity.Product;
import my.project.OnlineShopWithSpringBoot.entity.User;
import my.project.OnlineShopWithSpringBoot.service.BasketService;
import my.project.OnlineShopWithSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/user")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add_product_to_basket", method = RequestMethod.GET)
    public String addProductToBasket(@SessionAttribute("basket") Basket basket,
                                     @RequestParam("product_id") long productId) {
        Product product = productService.getProductById(productId).get();
        basket.getProductList().add(product);
        basketService.update(basket);
        return "redirect:/user/products";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basketForUser(@AuthenticationPrincipal User user,
                                Model model) {
        Long userId = user.getId();
        Basket basket = basketService.getBasketForUser(userId).get();
        List<Product> productList = basket.getProductList();
        model.addAttribute("products", productList);
        return "/user/basket";
    }
}
