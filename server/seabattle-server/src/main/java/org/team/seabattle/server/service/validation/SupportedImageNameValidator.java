package org.team.seabattle.server.service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SupportedImageNameValidator implements ConstraintValidator<SupportedImageName, String> {

  @Override
  public boolean isValid(String imageName, ConstraintValidatorContext context) {
    return SupportedImageExtension.validName(imageName);
  }
}
