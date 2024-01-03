package com.duccao.userservice.commands;

/**
 * Description of the class goes here.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */
public class SpringCommandBus implements CommandBus {

  private final CommandRegistry registry;

  public SpringCommandBus(CommandRegistry registry) {
    this.registry = registry;
  }

  @Override
  public <R, C extends Command<R>> R execute(C command) {
    CommandHandler<R, C> commandHandler = (CommandHandler<R, C>) registry.get(command.getClass());
    return commandHandler.handle(command);
  }
}
