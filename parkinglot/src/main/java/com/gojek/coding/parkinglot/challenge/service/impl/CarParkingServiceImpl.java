package com.gojek.coding.parkinglot.challenge.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.CollectionUtils;

import com.gojek.coding.parkinglot.challenge.domain.Vehicle;
import com.gojek.coding.parkinglot.challenge.enums.ParkingLotErrorCode;
import com.gojek.coding.parkinglot.challenge.exception.ParkingLotException;
import com.gojek.coding.parkinglot.challenge.service.ParkingService;

public class CarParkingServiceImpl implements ParkingService {

  private int                   totalSlots;
  private ParkingSlotHelper     parkingSlotHelper;
  private Map<Integer, Vehicle> slotMap;

  public CarParkingServiceImpl() {
    slotMap = new HashMap<>();
  }

  public void setTotalSlots(int totalSlots) {
    this.totalSlots = totalSlots;
  }

  @Override
  public void constructParkingLot(int capacity) throws ParkingLotException {
    if (capacity <= 0)
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_NOT_EXIST_ERROR, null);
    TreeSet slots = IntStream.range(1, totalSlots + 1).boxed().collect(Collectors.toCollection(TreeSet::new));
    this.parkingSlotHelper = new ParkingSlotHelper(slots);
    System.out.println("Created a parking lot with " + capacity + " slots");
  }

  @Override
  public void parkVehicle(Vehicle vehicle) throws ParkingLotException {
    checkParkingLotStatus();
    int slot = parkingSlotHelper.getSlot();
    if (slot == -1) {
      System.out.println("Sorry, parking lot is full");
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_NOT_EXIST_ERROR, null);
    }
    parkingSlotHelper.blockSlot(slot);
    slotMap.put(slot, vehicle);
    System.out.println("Allocated slot number:" + slot);
  }

  @Override
  public void unParkVehicleAtSlot(int slotNumber) throws ParkingLotException {
    checkParkingLotStatus();
    boolean isSlotBlocked = parkingSlotHelper.unBlockSlot(slotNumber);
    if (!isSlotBlocked) {
      System.out.println("The Slot:" + slotNumber + " is already free");
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_SLOT_NOT_BLOCKED, null);
    }
    slotMap.remove(slotNumber);
    System.out.println("Slot number " + slotNumber + " is free");
  }

  @Override
  public void getParkingLotStatus() throws ParkingLotException {
    checkParkingLotStatus();
    LinkedList<Integer> freeSlots = parkingSlotHelper.getFreeSlotStatus();
    if (!CollectionUtils.isEmpty(freeSlots)) {
      freeSlots.stream().forEachOrdered(it -> System.out.println("Slot number " + it + " is free"));
    }
    if (slotMap.size() > 0) {
      System.out.println(String.join(" ", "Slot No.", "Registration No", "Colour"));
      slotMap.entrySet()
          .stream()
          .forEach(entry -> System.out.println(
              String.join(" ", String.valueOf(entry.getKey()), entry.getValue().getRegistrationNumber(),
                  entry.getValue().getColour())));
    }
  }

  @Override
  public void getSlotNumbersFromVehicleColour(String colour) throws ParkingLotException {
    checkParkingLotStatus();
    if (slotMap.size() > 0) {
      List<Integer> filteredVehicles = slotMap.entrySet()
          .stream()
          .filter(entry -> entry.getValue().getColour().equals(colour))
          .map(entry -> entry.getKey())
          .collect(Collectors.toList());
      String registeredVehicles = filteredVehicles.stream().map(String::valueOf).collect(Collectors.joining(", "));
      System.out.println(registeredVehicles);
    } else {
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_LOT_EMPTY, null);
    }
  }

  @Override
  public void getSlotNumbersFromVehicleRegistrationNumber(String registrationNumber) throws ParkingLotException {
    checkParkingLotStatus();
    if (slotMap.size() > 0) {
      List<Integer> filteredVehicles = slotMap.entrySet()
          .stream()
          .filter(entry -> entry.getValue().getRegistrationNumber().equals(registrationNumber))
          .map(entry -> entry.getKey())
          .collect(Collectors.toList());
      System.out.println(filteredVehicles.get(0));
    } else {
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_LOT_EMPTY, null);
    }

  }

  @Override
  public void getVehicleRegistrationNumbersFromColour(String colour) throws ParkingLotException {
    checkParkingLotStatus();
    if (slotMap.size() > 0) {
      List<String> filteredVehicles = slotMap.entrySet()
          .stream()
          .filter(entry -> entry.getValue().getColour().equals(colour))
          .map(entry -> entry.getValue().getRegistrationNumber())
          .collect(Collectors.toList());
      String registeredVehicles = String.join(", ", filteredVehicles);
      System.out.println(registeredVehicles);
    } else {
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_LOT_EMPTY, null);
    }
  }

  private void checkParkingLotStatus() throws ParkingLotException {
    if (this.parkingSlotHelper == null)
      throw new ParkingLotException(ParkingLotErrorCode.PARKING_IS_NOT_CREATED, null);
  }
}
