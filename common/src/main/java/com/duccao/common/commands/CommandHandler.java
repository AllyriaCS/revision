package com.duccao.common.commands;

/**
 * Handler for a specific command with R is the return result and C is the command.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 2023.12.19
 */
public interface CommandHandler<R, C extends Command<R>> {

  R handle(C command);
}
