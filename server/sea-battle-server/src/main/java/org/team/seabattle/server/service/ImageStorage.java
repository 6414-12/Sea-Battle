package org.team.seabattle.server.service;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.team.seabattle.server.service.validation.SupportedImageName;

import java.io.*;

@Validated
@Component
public class ImageStorage {
  private final static String STORAGE_NAME = "images";

  @PostConstruct
  public void init() {
    new File(STORAGE_NAME).mkdirs();
  }

  /**
   * Place image file to \images dir
   * @param name image name
   * @param data image data
   * @return saved abstract representation of file and directory pathnames.
   */
  public File place(@SupportedImageName String name,
                    @NotNull byte[] data) {
    var path = STORAGE_NAME + "/" + name;
    var placeFile = new File(path);
    try {
      placeFile.createNewFile();
      try (var writer = new BufferedOutputStream(new FileOutputStream(placeFile))) {
        writer.write(data);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return placeFile;
  }

  public void delete(String path) {
    new File(path).delete();
  }
}
