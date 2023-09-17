package org.team.seabattle.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(com.finance.logger.config.LoggingConfig.class)
public class LoggingConfig {
}
