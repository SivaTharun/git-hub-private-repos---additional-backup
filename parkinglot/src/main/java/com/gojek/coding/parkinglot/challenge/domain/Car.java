package com.gojek.coding.parkinglot.challenge.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Car extends Vehicle {

  @Builder(builderMethodName = "markdownTableGroupBuilder")
  public Car(String registrationNumber, String colour) {
    super(registrationNumber, colour);
  }

}
