package com.example.market.service;

import com.example.market.model.dto.ContractDto;
import com.example.market.model.entity.ContractEntity;
import com.example.market.model.entity.UserEntity;
import com.example.market.model.projection.ContactView;
import com.example.market.model.repository.ContractRepository;
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
public class ContractServiceImpl implements ContractService {

  ContractRepository contractRepository;
  ItemRepository itemRepository;
  UserRepository userRepository;
  MarketMapper mapper;

  @Autowired
  public ContractServiceImpl(ContractRepository contractRepository,
      ItemRepository itemRepository,
      UserRepository userRepository, MarketMapper mapper) {
    this.contractRepository = contractRepository;
    this.itemRepository = itemRepository;
    this.userRepository = userRepository;
    this.mapper = mapper;
  }


  @Override
  public List<ContactView> findAll() {
    return contractRepository.getAll();
  }

  @Override
  public ContactView findById(Long id) {
    return contractRepository.getById(id);
  }

  @Override
  public void update(ContractDto request) {
    Optional<ContractEntity> optionalContract = contractRepository.findById(request.getId());
    Optional<UserEntity> optionalSeller = userRepository.findById(request.getSellerId());
    Optional<UserEntity> optionalBuyer = userRepository.findById(request.getBuyerId());

    if (optionalContract.isPresent() && optionalSeller.isPresent() && optionalBuyer.isPresent()) {
      ContractEntity entity = optionalContract.get();
      entity.setBuyer(optionalBuyer.get());
      entity.setSeller(optionalSeller.get());
      entity.setActive(request.getActive());
      contractRepository.save(entity);
    }


  }

  @Override
  public void save(ContractDto request) {
    Optional<UserEntity> optionalSeller = userRepository.findById(request.getSellerId());
    Optional<UserEntity> optionalBuyer = userRepository.findById(request.getBuyerId());
    if (optionalSeller.isPresent() && optionalBuyer.isPresent()) {
      UserEntity seller = optionalSeller.get();
      UserEntity buyer = optionalBuyer.get();
      ContractEntity entity = mapper.dtoToEntity(request);
      entity.setBuyer(buyer);
      entity.setSeller(seller);
      contractRepository.save(entity);
    }
  }
}
