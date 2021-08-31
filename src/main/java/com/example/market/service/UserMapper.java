package com.example.market.service;

import com.example.market.model.dto.UserDto;
import com.example.market.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mappings({})
  UserEntity dtoToEntity(UserDto dto);


}
