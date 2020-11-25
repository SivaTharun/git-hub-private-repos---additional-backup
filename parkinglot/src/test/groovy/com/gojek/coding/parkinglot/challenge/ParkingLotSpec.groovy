package com.gojek.coding.parkinglot.challenge

import com.gojek.coding.parkinglot.challenge.domain.Car
import com.gojek.coding.parkinglot.challenge.enums.ParkingLotErrorCode
import com.gojek.coding.parkinglot.challenge.exception.ParkingLotException
import com.gojek.coding.parkinglot.challenge.service.impl.CarParkingServiceImpl
import spock.lang.Specification

class ParkingLotSpec extends Specification {

  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private CarParkingServiceImpl carParkingService

  def setup() {
    carParkingService = new CarParkingServiceImpl()
    System.setOut(new PrintStream(outContent));
  }

  def cleanup() {
    System.setOut(null);
  }

  def "create parking lot spec"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    then:
    assert outContent.toString().trim() == "Created a parking lot with 6 slots"
  }

  def "park a vehicle spec"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 09111 56').colour('white').build())
    then:
    assert outContent.toString().split("\n")[1] == "Allocated slot number:1"
  }

  def "unpark a vehicle spec"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 09111 56').colour('white').build())
    carParkingService.unParkVehicleAtSlot(1)
    then:
    assert outContent.toString().split("\n")[2] == "Slot number 1 is free"
  }

  def "get parking lot status"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911156').colour('white').build())
    carParkingService.getParkingLotStatus()
    then:
    assert outContent.toString().split("\n")[2] == "Slot number 2 is free"
    assert outContent.toString().split("\n")[3] == "Slot number 3 is free"
    assert outContent.toString().split("\n")[4] == "Slot number 4 is free"
    assert outContent.toString().split("\n")[5] == "Slot number 5 is free"
    assert outContent.toString().split("\n")[6] == "Slot number 6 is free"
    assert outContent.toString().split("\n")[7] == "Slot No. Registration No Colour"
    assert outContent.toString().split("\n")[8] == "1 KA 0911156 white"
  }

  def "get slot numbers from vehicle color"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911156').colour('white').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911165').colour('blue').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911132').colour('white').build())
    carParkingService.getSlotNumbersFromVehicleColour('white')
    then:
    assert outContent.toString().split("\n")[4] == "1, 3"
  }

  def "get slot numbers from regsistration number"() {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911156').colour('white').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911165').colour('blue').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911132').colour('white').build())
    carParkingService.getSlotNumbersFromVehicleRegistrationNumber('KA 0911132')
    then:
    assert outContent.toString().split("\n")[4] == "3"
  }

  def "get vehicle registration numbers from colour"() throws Exception {
    given:
    carParkingService.setTotalSlots(6)
    when:
    carParkingService.constructParkingLot(6)
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911156').colour('white').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911165').colour('blue').build())
    carParkingService.parkVehicle(Car.builder().registrationNumber('KA 0911132').colour('white').build())
    carParkingService.getVehicleRegistrationNumbersFromColour('white')
    then:
    assert outContent.toString().split("\n")[4] == "KA 0911156, KA 0911132"
  }

  def "get construct parking lot -in correct capacity"() throws Exception {
    given:
    carParkingService.setTotalSlots(0)
    when:
    carParkingService.constructParkingLot(0)
    then:
    ParkingLotException parkingLotException = thrown()
    parkingLotException.parkingLotErrorCode == ParkingLotErrorCode.PARKING_NOT_EXIST_ERROR
  }


}
