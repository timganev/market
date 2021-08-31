package com.example.market.service.user;

import com.example.market.model.dto.UserDto;
import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.UserView;
import java.util.List;

public interface UserService {

  List<UserView> findAll();

  void delete(Long id);

  void update(UserDto request);

  void save(UserEntity request);
}
