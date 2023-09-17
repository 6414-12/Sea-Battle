package org.team.seabattle.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(com.finance.exception.ExceptionHandlerConfig.class)
public class ExceptionHandlerConfig {
}
