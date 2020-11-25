package com.gojek.coding.parkinglot.challenge.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParkingLotError implements Serializable {

  private String resource;
  private String field;
  private String reason;

}
