package my.project.OnlineShopWithSpringBoot.repository;

import my.project.OnlineShopWithSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

    User getUserByLoginAndPassword(String login, String password);
}

