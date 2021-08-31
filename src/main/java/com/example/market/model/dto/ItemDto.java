package com.example.market.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ItemDto {

  private Long id;
  private String name;
  private Long ownerId;

}
