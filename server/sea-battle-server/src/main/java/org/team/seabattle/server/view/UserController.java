package org.team.seabattle.server.view;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.team.seabattle.server.dto.UserDto;
import org.team.seabattle.server.entity.User;
import org.team.seabattle.server.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/api/v1/users/{id}")
  public ResponseEntity<User> findById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(userService.find(id));
  }

  @PostMapping("/api/v1/users")
  public void save(@RequestBody UserDto userDto) {
    userService.save(new User(userDto.getName()));
  }
}
