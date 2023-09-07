package org.team.seabattle.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team.seabattle.server.entity.User;
import org.team.seabattle.server.repository.UserRepository;

@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public void save(User user) {
    userRepository.save(user);
  }

  public User find(Long id) {
    return userRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("User not found!"));
  }

}
