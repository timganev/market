package com.example.market.service;

import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.UserView;
import com.example.market.model.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService{

  UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserView> findAll() {
    return userRepository.getAll();
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public void update(UserEntity request) {
    Optional<UserEntity> optinal = userRepository.findById(request.getId());
    if(optinal.isPresent()){
      userRepository.save(request);
    }
  }

  @Override
  public void save(UserEntity request) {
    userRepository.save(request);
  }
}
