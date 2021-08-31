package com.example.market.web;

import com.example.market.model.dto.UserDto;
import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.UserView;
import com.example.market.service.mapper.MarketMapper;
import com.example.market.service.user.UserService;
import com.example.market.service.validation.ValidationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;
  private final MarketMapper marketMapper;
  private final ValidationService validationService;

  @Autowired
  public UserController(UserService userService, MarketMapper marketMapper, ValidationService validationService) {
    this.userService = userService;
    this.marketMapper = marketMapper;
    this.validationService = validationService;
  }


  @GetMapping(value = "/user")
  public ResponseEntity<List<UserView>> findAllUsers() {
    List<UserView> list = userService.findAll();
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
        .body(list);
  }


  @DeleteMapping(value = "/user/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    userService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PutMapping(value = "/user")
  public ResponseEntity<Void> editUser(@RequestBody UserDto request) {
    userService.update(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PostMapping(value = "/user")
  public ResponseEntity<Void> saveUser(@RequestBody UserDto request) {
    UserEntity entity = marketMapper.dtoToEntity(request);
    userService.save(entity);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}