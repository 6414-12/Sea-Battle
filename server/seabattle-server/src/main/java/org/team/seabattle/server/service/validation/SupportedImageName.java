package org.team.seabattle.server.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SupportedImageNameValidator.class)
@Documented
public @interface SupportedImageName {
  String message() default "Image extension not supported";
  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
}
