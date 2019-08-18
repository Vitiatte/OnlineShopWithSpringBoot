package my.project.OnlineShopWithSpringBoot.service.impl;

import my.project.OnlineShopWithSpringBoot.entity.Basket;
import my.project.OnlineShopWithSpringBoot.entity.User;
import my.project.OnlineShopWithSpringBoot.repository.BasketJpaRepository;
import my.project.OnlineShopWithSpringBoot.repository.UserJpaRepository;
import my.project.OnlineShopWithSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private BasketJpaRepository basketJpaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void add(User user, String nonHashedPass) {
        user.setPassword(passwordEncoder.encode(nonHashedPass));
        long userId = userJpaRepository.save(user).getId();
        if (user.getUserRole().equals("USER_ROLE")) {
            Basket basket = new Basket();
            basket.setUserId(userId);
            basketJpaRepository.save(basket);
        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userJpaRepository.getOne(id));
    }

    @Transactional
    @Override
    public Optional<User> getUserByLoginAndPass(String login, String pass) {
        return Optional.ofNullable(userJpaRepository.getUserByLoginAndPassword(login, pass));
    }

    @Transactional
    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.ofNullable(userJpaRepository.getUserByLogin(login));
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userJpaRepository.findAll();
    }

    @Override
    public boolean isLoginCorrect(String login) {
        return Objects.nonNull(login)
                && !login.isEmpty()
                && !getUserByLogin(login).isPresent();
    }

    @Override
    public boolean isPasswordCorrect(String pass, String passRepeat) {
        return Objects.nonNull(pass)
                && !pass.isEmpty()
                && pass.equals(passRepeat);
    }

    @Transactional
    @Override
    public void update(User user) {
        userJpaRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userJpaRepository.delete(user);
    }
}
