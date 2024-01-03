package com.duccao.userservice.example;

public record UserResponse(String firstName, String lastName) {

  public static UserResponse mapFromEntity(UserEntity entity) {
    return new UserResponse(entity.getFirstName(), entity.getLastName());
  }
}