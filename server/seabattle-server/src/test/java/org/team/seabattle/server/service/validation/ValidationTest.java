package org.team.seabattle.server.service.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.team.seabattle.server.service.ImageStorage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ValidationTestContext.class)
public class ValidationTest {
  @Autowired
  private ImageStorage imageStorage;

  @ParameterizedTest
  @MethodSource("shouldThrowByWrongImageNameArgs")
  void shouldThrowByWrongImageName(String imageName, boolean willThrow) {
    Executable task = () -> {
      imageStorage.init();
      imageStorage.delete(
        imageStorage.place(imageName, new byte[]{})
          .getAbsolutePath()
      );
    };
    if (willThrow) {
      assertThrows(ConstraintViolationException.class, task);
    } else {
      assertDoesNotThrow(task);
    }
  }

  private static Stream<Arguments> shouldThrowByWrongImageNameArgs() {
    return Stream.of(
      Arguments.of("test", true),
      Arguments.of("test.qwe", true),
      Arguments.of("test.test", true),
      Arguments.of(".test", true),
      Arguments.of("", true),
      Arguments.of("test.jpg", false)
    );
  }
}
