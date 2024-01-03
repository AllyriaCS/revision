package com.duccao.userservice.example;

import com.duccao.userservice.commands.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of the class goes here.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */
@RestController
@RequestMapping("/api/v1/users")
class UserController {

  private final CommandBus commandBus;

  @Autowired
  public UserController(CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  @GetMapping("/{id}")
  ResponseEntity<UserResponse> getUserById(@PathVariable(name = "id") Long id) {
    GetUserByIdCommand command = new GetUserByIdCommand(id);
    return ResponseEntity.ok(commandBus.execute(command));
  }
}