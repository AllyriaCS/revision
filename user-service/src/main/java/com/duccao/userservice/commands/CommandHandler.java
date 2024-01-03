package com.duccao.userservice.commands;

/**
 * Handler command.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 2023.12.19
 */
public interface CommandHandler<R, C extends Command<R>> {

  R handle(C command);
}
