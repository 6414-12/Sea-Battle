package org.team.seabattle.server.view;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.team.seabattle.server.view.dto.RegisterDto;

@RestController
public class AuthController {

  public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {

    throw new UnsupportedOperationException();
  }
}
