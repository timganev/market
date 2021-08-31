package com.example.market.web;

import com.example.market.model.dto.ItemDto;
import com.example.market.model.entity.ItemEntity;
import com.example.market.model.projection.ItemView;
import com.example.market.service.mapper.MarketMapper;
import com.example.market.service.item.ItemService;
import com.example.market.service.validation.ValidationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  private final ItemService itemService;
  private final MarketMapper marketMapper;
  private final ValidationService validationService;

  @Autowired
  public ItemController(ItemService itemService, MarketMapper marketMapper, ValidationService validationService) {
    this.itemService = itemService;
    this.marketMapper = marketMapper;
    this.validationService = validationService;
  }


  @GetMapping(value = "/item")
  public ResponseEntity<List<ItemView>> findAllItems() {
    List<ItemView> list = itemService.findAll();
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
  }

  @GetMapping(value = "/item/{id}")
  public ResponseEntity<ItemView> findItemById(@PathVariable("id") Long id) {
    ItemView list = itemService.findItemById(id);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
  }


  @PutMapping(value = "/item")
  public ResponseEntity<Void> editItem(@RequestBody ItemDto request) {
    itemService.update(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PostMapping(value = "/item")
  public ResponseEntity<Void> saveItem(@RequestBody ItemDto request) {
    itemService.save(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}