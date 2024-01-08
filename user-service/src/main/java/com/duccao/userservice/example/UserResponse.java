package com.duccao.userservice.example;

public record UserResponse(String firstName, String lastName) {

  public static UserResponse fromEntity(UserEntity entity) {
    return new UserResponse(entity.getFirstName(), entity.getLastName());
  }
}
