package com.example.market.service;

import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.UserView;
import java.util.List;

public interface UserService {

  List<UserView> findAll();

  void delete(Long id);

  void update(UserEntity request);

  void save(UserEntity request);
}
