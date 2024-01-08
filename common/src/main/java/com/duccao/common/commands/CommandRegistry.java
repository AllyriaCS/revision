package com.duccao.common.commands;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

/**
 * Registry holds the mapping between a command and its handler.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */
public class CommandRegistry {

  private final Map<Class<? extends Command<?>>, CommandHandler<?, ? extends Command<?>>> registry = new HashMap<>();

  public CommandRegistry(ApplicationContext applicationContext) {
    Map<String, CommandHandler> handlers = applicationContext.getBeansOfType(CommandHandler.class);

    for (String name : handlers.keySet()) {
      CommandHandler<?, ?> handler = handlers.get(name);
      Class<?>[] handlerTypes = GenericTypeResolver.resolveTypeArguments(handler.getClass(), CommandHandler.class);
      Class<? extends Command<?>> commandType = (Class<? extends Command<?>>) handlerTypes[1];
      registry.put(commandType, handler);
    }
  }

  public <R, C extends Command<R>> CommandHandler<R, C> get(Class<C> commandClass) {
    return (CommandHandler<R, C>) registry.get(commandClass);
  }
}
