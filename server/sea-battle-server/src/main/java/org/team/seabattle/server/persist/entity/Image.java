package org.team.seabattle.server.persist.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.team.seabattle.server.service.validation.ImageShouldExists;

import java.io.*;
import java.util.Arrays;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String path;
  @Transient
  @ImageShouldExists
  private File imageFile;

  public Image(String path) {
    this.imageFile = new File(path);
    this.path = path;
  }

  @PostLoad
  private void initFile() {
    imageFile = new File(path);
  }

  /**
   * Max image size = 2GB
   * @return image data
   */
  public byte[] getData() {
    try (var bis = new BufferedInputStream(new FileInputStream(imageFile))) {
       return bis.readAllBytes();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
