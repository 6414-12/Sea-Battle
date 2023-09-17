package org.team.seabattle.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.team.seabattle.server.infra.persist.UserRepository;
import org.team.seabattle.server.entity.User;

@Validated
@Service
@Transactional
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByName(username)
      .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found"));
  }

  @Override
  public User save(User user) {
    if (userRepository.findUserByName(user.getUsername()).isEmpty()) {
      return userRepository.save(user);
    }
    throw new IllegalArgumentException("User with name " + user.getUsername() + " is already present");
  }
}
