package com.duccao.common.commands;

/**
 * This component responsible for executing command by passing down the Command object to the appropriate handler.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 2023.12.19
 */
public interface CommandBus {

  <R, C extends Command<R>> R execute(C command);
}
