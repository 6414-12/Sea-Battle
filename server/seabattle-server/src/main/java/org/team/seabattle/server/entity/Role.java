package org.team.seabattle.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
  USER("ROLE_USER");

  private String name;

  Role(String name) {
    this.name = name;
  }

  public static Role byName(String name) {
    for (Role role : Role.values()) {
      if (role.name.equals(name)) {
        return role;
      }
    }
    throw new IllegalArgumentException("Role with name: " + name + " not found");
  }

  @Override
  public String getAuthority() {
    return name;
  }
}
