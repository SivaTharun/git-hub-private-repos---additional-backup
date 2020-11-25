package com.gojek.coding.parkinglot.challenge.service;

import com.gojek.coding.parkinglot.challenge.domain.Vehicle;
import com.gojek.coding.parkinglot.challenge.exception.ParkingLotException;

public interface ParkingService<T extends Vehicle> {

  void constructParkingLot(int capacity) throws ParkingLotException;

  void parkVehicle(Vehicle vehicle) throws ParkingLotException;

  void unParkVehicleAtSlot(int slotNumber) throws ParkingLotException;

  void getParkingLotStatus() throws ParkingLotException;

  void getSlotNumbersFromVehicleColour(String colour) throws ParkingLotException;

  void getSlotNumbersFromVehicleRegistrationNumber(String registrationNumber) throws ParkingLotException;

  void getVehicleRegistrationNumbersFromColour(String colour) throws ParkingLotException;

}
