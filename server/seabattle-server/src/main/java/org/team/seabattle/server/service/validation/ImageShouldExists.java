package org.team.seabattle.server.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageShouldExistsValidator.class)
@Documented
public @interface ImageShouldExists {
  String message() default "Image does not exists";
  Class<?>[] groups() default { };
  Class<? extends Payload>[] payload() default { };
}
