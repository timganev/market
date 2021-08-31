package com.example.market.service;

import com.example.market.model.dto.ContractDto;
import com.example.market.model.dto.ItemDto;
import com.example.market.model.projection.ContactView;
import com.example.market.model.projection.ItemView;
import java.util.List;

public interface ContractService {

  List<ContactView> findAll();

  ContactView findById(Long id);

  void update(ContractDto request);

  void save(ContractDto request);


}
