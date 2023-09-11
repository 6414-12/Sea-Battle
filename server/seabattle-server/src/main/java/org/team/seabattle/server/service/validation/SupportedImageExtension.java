package org.team.seabattle.server.service.validation;

import java.util.Arrays;

public enum SupportedImageExtension {
  JPG("jpg");

  private final String extension;

  SupportedImageExtension(String extension) {
    this.extension = extension;
  }

  public static boolean validName(String name) {
    var pathParts = name.split("\\.");
    if (pathParts.length != 2) return false;
    return Arrays.stream(values())
      .anyMatch(ext -> ext.extension.equals(pathParts[1]));
  }
}
