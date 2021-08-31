package com.example.market.model.repository;

import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.UserView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


  @Query(value = "SELECT user.id AS id, user.username AS username FROM UserEntity user "
      + " ORDER BY user.id ")
  List<UserView> getAll();

}
