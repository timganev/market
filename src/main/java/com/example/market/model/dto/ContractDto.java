package com.example.market.model.dto;

import com.example.market.model.entity.UserEntity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ContractDto {

  private Long id;
  private Long sellerId;
  private Long buyerId;
  private Boolean active;

}
