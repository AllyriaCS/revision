package com.duccao.userservice.commands;

/**
 * Finds and delegate the execution to appropriate command handler.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 2023.12.19
 */
public interface CommandBus {

  <R, C extends Command<R>> R execute(C command);
}
