package org.team.seabattle.server.service.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.team.seabattle.server.service.ImageStorage;

@Configuration
public class ValidationTestContext {
  @Bean
  public LocalValidatorFactoryBean validatorFactoryBean() {
    return new LocalValidatorFactoryBean();
  }

  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }

  @Bean
  public ImageStorage imageStorage() {
    return new ImageStorage();
  }
}
