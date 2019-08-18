package my.project.OnlineShopWithSpringBoot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String userRole;

    public User() {
    }

    public static Builder getBuilder() {
        return new User().new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList((GrantedAuthority) () -> User.this.getUserRole().toString());
    }

    @Override
    public String getUsername() {
        return this.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Long id) {
            User.this.id = id;
            return Builder.this;
        }

        public Builder setLogin(String login) {
            User.this.login = login;
            return Builder.this;
        }

        public Builder setHashedPassword(String password) {
            User.this.password = password;
            return Builder.this;
        }

        public Builder setUserRole(String role) {
            User.this.userRole = role;
            return Builder.this;
        }

        public User build() {
            return User.this;
        }
    }
}
