package com.example.market.service.mapper;

import com.example.market.model.dto.ItemDto;
import com.example.market.model.dto.UserDto;
import com.example.market.model.entity.ItemEntity;
import com.example.market.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MarketMapper {

  @Mappings({})
  UserEntity dtoToEntity(UserDto dto);

  @Mappings({})
  ItemEntity dtoToEntity(ItemDto dto);

}
