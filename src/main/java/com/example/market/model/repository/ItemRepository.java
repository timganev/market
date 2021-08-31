package com.example.market.model.repository;

import com.example.market.model.entity.ItemEntity;
import com.example.market.model.projection.ItemView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

  @Query(value = "SELECT  item.id AS id, item.name AS name, item.owner.id AS owner FROM ItemEntity item "
      + " ORDER BY item.id ")
  List<ItemView> getAll();


  @Query(value = "SELECT item.id AS id, item.name AS name, item.owner.id AS owner FROM ItemEntity item "
      + " WHERE item.id = :id")
  ItemView getItemById(@Param("id") Long id);

}
