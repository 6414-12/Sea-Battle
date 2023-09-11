package org.team.seabattle.server.entity;

import com.finance.jwt.security.authentication.UserDetailsExtend;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Table(name = "users")
public class User implements UserDetailsExtend {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_sequence")
  @SequenceGenerator(name = "users_id_sequence", allocationSize = 10)
  private Long id;

  @NotBlank
  private String name;

  @Size(min = 6, max = 80)
  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  private Image image;

  public User() {
  }

  public User(Long id, String name, String password, Image image) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.image = image;
  }

  public User(String name, String password, Image image) {
    this(null, name, password, image);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, password);
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>(List.of(Role.USER));
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public String getPassword() {
    return password;
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
}