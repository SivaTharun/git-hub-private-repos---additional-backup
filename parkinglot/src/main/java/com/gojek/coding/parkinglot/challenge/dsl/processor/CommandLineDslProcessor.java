package com.gojek.coding.parkinglot.challenge.dsl.processor;

import com.gojek.coding.parkinglot.challenge.constants.CommandConstants;
import com.gojek.coding.parkinglot.challenge.domain.Car;
import com.gojek.coding.parkinglot.challenge.exception.ParkingLotException;
import com.gojek.coding.parkinglot.challenge.service.impl.CarParkingServiceImpl;

public class CommandLineDslProcessor {
  private CarParkingServiceImpl carParkingService;

  public CommandLineDslProcessor(CarParkingServiceImpl carParkingService) {
    this.carParkingService = carParkingService;
  }

  public void processDSLCommands(String inputString) throws ParkingLotException {
    String[] inputValues = inputString.split(" ");
    String key = inputValues[0];
    switch (key) {
      case CommandConstants.CREATE_PARKING_LOT:
        int totalSlots = Integer.parseInt(inputValues[1]);
        carParkingService.setTotalSlots(totalSlots);
        carParkingService.constructParkingLot(totalSlots);
        break;
      case CommandConstants.PARK:
        carParkingService.parkVehicle(Car.builder().registrationNumber(inputValues[1]).colour(inputValues[2]).build());
        break;
      case CommandConstants.LEAVE:
        carParkingService.unParkVehicleAtSlot(Integer.parseInt(inputValues[1]));
        break;
      case CommandConstants.STATUS:
        carParkingService.getParkingLotStatus();
        break;
      case CommandConstants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
        carParkingService.getVehicleRegistrationNumbersFromColour(inputValues[1]);
        break;
      case CommandConstants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
        carParkingService.getSlotNumbersFromVehicleColour(inputValues[1]);
        break;
      case CommandConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
        carParkingService.getSlotNumbersFromVehicleRegistrationNumber(inputValues[1]);
        break;
    }

  }
}
