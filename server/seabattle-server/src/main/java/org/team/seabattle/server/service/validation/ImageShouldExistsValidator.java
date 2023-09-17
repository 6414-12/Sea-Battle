package org.team.seabattle.server.service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.io.File;

public class ImageShouldExistsValidator implements ConstraintValidator<ImageShouldExists, File>{
  @Override
  public boolean isValid(File file, ConstraintValidatorContext context) {
    return file.exists();
  }
}
