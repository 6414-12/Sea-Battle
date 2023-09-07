package org.team.seabattle.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.team.seabattle.server.repository.UserRepository;
import org.team.seabattle.server.service.UserService;

@Configuration
public class UserConfig {
  @Bean
  public UserService userService(UserRepository userRepository) {
    return new UserService(userRepository);
  }
}
