package com.example.market.service.item;

import com.example.market.model.dto.ItemDto;
import com.example.market.model.entity.ItemEntity;
import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.ItemView;
import com.example.market.model.repository.ItemRepository;
import com.example.market.model.repository.UserRepository;
import com.example.market.service.mapper.MarketMapper;
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
public class ItemServiceImpl implements ItemService{

  ItemRepository itemRepository;
  UserRepository userRepository;
  MarketMapper mapper;

  @Autowired
  public ItemServiceImpl(ItemRepository itemRepository,
      UserRepository userRepository, MarketMapper mapper) {
    this.itemRepository = itemRepository;
    this.userRepository = userRepository;
    this.mapper = mapper;
  }


  @Override
  public List<ItemView> findAll() {
    return itemRepository.getAll();
  }

  @Override
  public ItemView findById(Long id) {
    return itemRepository.getItemById(id);
  }

  @Override
  public void update(ItemDto request) {
    Optional<ItemEntity> optional = itemRepository.findById(request.getId());
    if(optional.isPresent()){
      ItemEntity entity = optional.get();
      entity.setName(request.getName());
      itemRepository.save(entity);
    }
  }

  @Override
  public void save(ItemDto request) {

    Optional<UserEntity> optional = userRepository.findById(request.getOwnerId());
    if(optional.isPresent()){
      UserEntity seller = optional.get();
      ItemEntity itemEntity = mapper.dtoToEntity(request);
      itemEntity.setOwner(seller);
      itemRepository.save(itemEntity);
    }
  }
}
