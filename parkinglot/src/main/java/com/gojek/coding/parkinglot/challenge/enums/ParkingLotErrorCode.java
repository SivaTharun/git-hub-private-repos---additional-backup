package com.gojek.coding.parkinglot.challenge.enums;

public enum ParkingLotErrorCode {

  BAD_DSL_COMMAND("Invalid DSL command."),
  PARKING_ALREADY_EXIST("Parking is Already Created,It CAN NOT be again recreated."),
  PARKING_NOT_EXIST_ERROR("Sorry, No more Car Parking Exists"),
  INTERNAL_ERROR("Internal Error"),
  PARKING_IS_NOT_CREATED("Parking lot is not created"),
  PARKING_SLOT_NOT_BLOCKED("The Parking slot was not blocked"),
  PARKING_SLOT_CAN_NOT_BE_CREATED("The Parking slot can not be created"),
  PARKING_LOT_EMPTY("The Parking slot is empty");

  private String code;

  ParkingLotErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

}
