package com.duccao.userservice.example;

import com.duccao.userservice.commands.Command;
import java.io.Serializable;

/**
 * Description of the class goes here.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */
public record GetUserByIdCommand(Long id) implements Command<UserResponse>, Serializable {

}