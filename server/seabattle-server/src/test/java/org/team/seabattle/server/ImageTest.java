package org.team.seabattle.server;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.team.seabattle.server.entity.Image;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {

  @ParameterizedTest
  @MethodSource("shouldGetSomeDataArgs")
  void shouldGetSomeData(String fileName) {
    var resource = getClass().getClassLoader().getResource(fileName);
    if (resource == null) throw new IllegalArgumentException(fileName + " not exists");
    var image = new Image(resource.getPath());
    var data = image.getData();

    assertEquals((int)image.getImageFile().length(), data.length);
  }

  private static Stream<Arguments> shouldGetSomeDataArgs() {
    return Stream.of(
      Arguments.of("testimage1.jpg"),
      Arguments.of("testimage2.jpg")
    );
  }


}
