package com.example.market.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

  private Long id;
  private String username;
  private Long account;

}
