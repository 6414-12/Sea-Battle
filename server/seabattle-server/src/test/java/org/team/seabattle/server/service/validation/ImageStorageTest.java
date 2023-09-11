package org.team.seabattle.server.service.validation;

import org.junit.jupiter.api.Test;
import org.team.seabattle.server.entity.Image;
import org.team.seabattle.server.service.ImageStorage;

import static org.junit.jupiter.api.Assertions.*;

class ImageStorageTest {
  private final ImageStorage imageStorage = new ImageStorage();

  @Test
  void shouldCopyFile() {
    final String fileName = "testimage1.jpg";
    final String copyFilename = "testimage1-copy.jpg";
    var resource = getClass().getClassLoader().getResource(fileName);
    if (resource == null) throw new IllegalArgumentException(fileName + " not exists");
    var image = new Image(resource.getPath());
    imageStorage.init();
    var savedFile = imageStorage.place(copyFilename, image.getData());

    assertEquals(copyFilename, savedFile.getName());
    assertTrue(savedFile.exists());
    assertTrue(savedFile.isFile());
    assertTrue(savedFile.length() > 0);
    imageStorage.delete(savedFile.getAbsolutePath());
  }

}