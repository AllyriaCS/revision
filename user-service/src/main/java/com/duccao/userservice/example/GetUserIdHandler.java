package com.duccao.userservice.example;

import com.duccao.common.commands.CommandHandler;
import com.duccao.userservice.exceptions.BusinessError;
import com.duccao.userservice.exceptions.BusinessException;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Description of the class goes here.
 *
 * @author Duc Cao
 * @version 1.0
 * @since 1/2/2024
 */

@Component
public class GetUserIdHandler implements CommandHandler<UserResponse, GetUserByIdCommand> {

  private final UserRepository userRepository;

  public GetUserIdHandler(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponse handle(GetUserByIdCommand command) {
    Optional<UserEntity> userOptional = userRepository.findById(command.id());
    if (userOptional.isEmpty()) {
      throw new BusinessException(BusinessError.ENTITY_NOT_FOUND);
    }
    return UserResponse.fromEntity(userOptional.get());
  }
}
