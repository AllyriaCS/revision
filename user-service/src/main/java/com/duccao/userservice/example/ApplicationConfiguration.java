package com.duccao.userservice.example;

import com.duccao.userservice.commands.CommandBus;
import com.duccao.userservice.commands.CommandRegistry;
import com.duccao.userservice.commands.SpringCommandBus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description of the class goes here.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */
@Configuration
public class ApplicationConfiguration {

  @Bean
  public CommandBus commandBus(ApplicationContext applicationContext) {
    return new SpringCommandBus(new CommandRegistry(applicationContext));
  }
}
