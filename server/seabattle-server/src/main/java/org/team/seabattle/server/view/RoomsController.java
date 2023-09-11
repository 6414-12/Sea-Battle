package org.team.seabattle.server.view;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.team.seabattle.server.view.dto.CreateRoomDto;

@RestController
public class RoomsController {

  @PostMapping("/api/v1/rooms")
  public ResponseEntity<Long> createRoom(@RequestBody CreateRoomDto createRoomDto) {
    throw new UnsupportedOperationException();
  }
}
