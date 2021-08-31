package com.example.market.model.repository;


import com.example.market.model.entity.ContractEntity;
import com.example.market.model.projection.ContactView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

  @Query(value = "SELECT  c.id AS id, c.seller.id AS seller, c.buyer.id AS buyer, c.active as active  FROM ContractEntity c "
      + " ORDER BY c.id ")
  List<ContactView> getAll();


  @Query(value = "SELECT  c.id AS id, c.seller.id AS seller, c.buyer.id AS buyer, c.active as active  FROM ContractEntity c "
      + " WHERE c.active = true "
      + " ORDER BY c.id ")
  List<ContactView> getActive();


}
