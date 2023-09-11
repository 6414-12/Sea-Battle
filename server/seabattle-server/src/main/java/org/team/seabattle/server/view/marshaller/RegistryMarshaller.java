package org.team.seabattle.server.view.marshaller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.team.seabattle.server.entity.Image;
import org.team.seabattle.server.entity.User;
import org.team.seabattle.server.view.dto.LoginDto;
import org.team.seabattle.server.view.dto.RegisterDto;

@Component
@RequiredArgsConstructor
public class RegistryMarshaller {
  private final PasswordEncoder passwordEncoder;

  public User marshallRegisterDtoToUser(RegisterDto registerDto, Image avatar) {
    return new User(
      registerDto.name(),
      passwordEncoder.encode(registerDto.password()),
      avatar
    );
  }

  public LoginDto marshallRegisterDtoToLoginDto(RegisterDto registerDto) {
    return new LoginDto(
      registerDto.name(),
      registerDto.password()
    );
  }
}
