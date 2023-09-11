package org.team.seabattle.server.view;

import com.finance.jwt.security.authentication.AccessAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.team.seabattle.server.entity.Image;
import org.team.seabattle.server.service.ImageStorage;
import org.team.seabattle.server.service.UserService;
import org.team.seabattle.server.view.dto.LoginDto;
import org.team.seabattle.server.view.dto.RegisterDto;
import org.team.seabattle.server.view.marshaller.RegistryMarshaller;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
  private final UserService userService;
  private final ImageStorage imageStorage;
  private final AccessAuthenticationService authenticateService;
  private final RegistryMarshaller registryMarshaller;

  @PostMapping("/api/v1/register")
  public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
    var imageFile = imageStorage.place(
      registerDto.image().name(),
      registerDto.image().data()
    );
    userService.save(registryMarshaller.marshallRegisterDtoToUser(
      registerDto,
      new Image(imageFile)
    ));
    return ResponseEntity.status(201)
      .build();
  }

  @PostMapping("/api/v1/login")
  public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
    var accessToken = authenticateService.login(
      new UsernamePasswordAuthenticationToken(
        loginDto.name(),
        loginDto.password()
      )
    );
    return ResponseEntity.status(200)
      .body(Map.of("accessToken", accessToken.getBody()));
  }

  @PostMapping("/api/v1/weakpoint/register-login")
  public ResponseEntity<?> registerAndLogin(@RequestBody RegisterDto registerDto) {
    register(registerDto);
    return login(
      new LoginDto(
        registerDto.name(),
        registerDto.password()
      )
    );
  }
}
