package my.project.OnlineShopWithSpringBoot.service.impl;

import my.project.OnlineShopWithSpringBoot.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

  @Autowired
  private UserJpaRepository userJpaRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userJpaRepository.getUserByLogin(username);
  }
}
