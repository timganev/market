package com.example.market.service.item;

import com.example.market.model.dto.ItemDto;
import com.example.market.model.projection.ItemView;
import java.util.List;

public interface ItemService {

  List<ItemView> findAll();

  ItemView findById(Long id);

  void update(ItemDto request);

  void save(ItemDto request);


}
