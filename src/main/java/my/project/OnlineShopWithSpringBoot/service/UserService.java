package my.project.OnlineShopWithSpringBoot.service;

import my.project.OnlineShopWithSpringBoot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void add(User user, String nonHashedPass);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByLoginAndPass(String login, String pass);

    Optional<User> getUserByLogin(String login);

    List<User> getAllUsers();

    boolean isLoginCorrect(String login);

    boolean isPasswordCorrect(String pass, String passRepeat);

    void update(User user);

    void delete(User user);
}
