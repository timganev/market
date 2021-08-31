package com.example.market.web;

import com.example.market.model.dto.ContractDto;
import com.example.market.model.projection.ContactView;
import com.example.market.service.ContractService;
import com.example.market.service.mapper.MarketMapper;
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
public class ContractController {

  private final ContractService contractService;
  private final MarketMapper marketMapper;
  private final ValidationService validationService;

  @Autowired
  public ContractController(ContractService contractService, MarketMapper marketMapper, ValidationService validationService) {
    this.contractService = contractService;
    this.marketMapper = marketMapper;
    this.validationService = validationService;
  }


  @GetMapping(value = "/contract")
  public ResponseEntity<List<ContactView>> findAll() {
    List<ContactView> list = contractService.findAll();
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
  }

  @GetMapping(value = "/contract/{id}")
  public ResponseEntity<ContactView> findById(@PathVariable("id") Long id) {
    ContactView view = contractService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(view);
  }


  @PutMapping(value = "/contract")
  public ResponseEntity<Void> edit(@RequestBody ContractDto request) {
    contractService.update(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @PostMapping(value = "/contract")
  public ResponseEntity<Void> save(@RequestBody ContractDto request) {
    contractService.save(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}