package org.team.seabattle.server.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.team.seabattle.server.entity.User;

public interface UserService extends UserDetailsService {
  User save(@Valid @NotNull User user);
}
