package com.gojek.coding.parkinglot.challenge.exception;

import com.gojek.coding.parkinglot.challenge.domain.ParkingLotError;
import com.gojek.coding.parkinglot.challenge.enums.ParkingLotErrorCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ParkingLotException extends Exception {

  private final ParkingLotErrorCode   parkingLotErrorCode;
  private final List<ParkingLotError> parkingLotErrors;

  public ParkingLotException(ParkingLotErrorCode parkingLotErrorCode, List<ParkingLotError> parkingLotErrors) {
    this.parkingLotErrorCode = parkingLotErrorCode;
    this.parkingLotErrors = parkingLotErrors;
  }

  public ParkingLotException(String message, ParkingLotErrorCode parkingLotErrorCode, List<ParkingLotError> parkingLotErrors) {
    super(message);
    this.parkingLotErrorCode = parkingLotErrorCode;
    this.parkingLotErrors = parkingLotErrors;
  }

  public ParkingLotException(String message, Throwable cause, ParkingLotErrorCode parkingLotErrorCode, List<ParkingLotError> parkingLotErrors) {
    super(message, cause);
    this.parkingLotErrorCode = parkingLotErrorCode;
    this.parkingLotErrors = parkingLotErrors;
  }

  public ParkingLotException(Throwable cause, ParkingLotErrorCode parkingLotErrorCode, List<ParkingLotError> parkingLotErrors) {
    super(cause);
    this.parkingLotErrorCode = parkingLotErrorCode;
    this.parkingLotErrors = parkingLotErrors;
  }

  public ParkingLotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ParkingLotErrorCode parkingLotErrorCode, List<ParkingLotError> parkingLotErrors) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.parkingLotErrorCode = parkingLotErrorCode;
    this.parkingLotErrors = parkingLotErrors;
  }
}
